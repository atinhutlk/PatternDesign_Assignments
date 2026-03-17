
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;
    private Stage historyStage;
    private ListView<String> historyListView;
    private boolean isRefreshingHistory;

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        Button historyButton = new Button("History");
        historyButton.setOnAction(event -> openHistoryWindow());

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        HBox.setMargin(colorBox1.getRectangle(), insets);
        HBox.setMargin(colorBox2.getRectangle(), insets);
        HBox.setMargin(colorBox3.getRectangle(), insets);

        Label label = new Label("Press Ctrl-Z to undo and Ctrl-Y to redo the last change.");
        label.setPadding(insets);

        HBox actionBox = new HBox(checkBox, historyButton);
        actionBox.setSpacing(10);
        actionBox.setPadding(insets);

        // create a VBox that contains the HBox and controls
        VBox vBox = new VBox(hBox, actionBox, label);
        // call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> controller.setIsSelected(checkBox.isSelected()));

        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                // Ctrl-Z: undo
                System.out.println("Undo key combination pressed");
                controller.undo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                // Ctrl-Y: redo
                System.out.println("Redo key combination pressed");
                controller.redo();
            }
        });


        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
        refreshHistoryWindow();
    }

    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    public void refreshHistoryWindow() {
        if (historyListView == null) {
            return;
        }

        isRefreshingHistory = true;
        historyListView.getItems().setAll(controller.getHistoryLabels());
        historyListView.getSelectionModel().selectLast();
        isRefreshingHistory = false;
    }

    private void openHistoryWindow() {
        if (historyStage == null) {
            historyListView = new ListView<>();
            historyListView.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
                if (isRefreshingHistory) {
                    return;
                }

                int selectedIndex = newValue.intValue();
                if (selectedIndex >= 0) {
                    controller.restoreFromHistoryIndex(selectedIndex);
                }
            });

            VBox root = new VBox(historyListView);
            root.setPadding(new Insets(10));

            historyStage = new Stage();
            historyStage.setTitle("State History");
            historyStage.setScene(new Scene(root, 420, 320));
        }

        refreshHistoryWindow();
        historyStage.show();
        historyStage.toFront();
    }
}