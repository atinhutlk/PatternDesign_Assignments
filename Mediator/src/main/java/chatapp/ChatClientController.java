package chatapp;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatClientController {

    private ChatClient client;
    private ChatMediator mediator;

    private TextArea messageArea;
    private TextField messageField;
    private ComboBox<String> receiverBox;

    public ChatClientController(ChatClient client, ChatMediator mediator) {
        this.client = client;
        this.mediator = mediator;
    }

    public void showWindow() {
        Stage stage = new Stage();
        stage.setTitle(client.getUsername());

        messageArea = new TextArea();
        messageArea.setEditable(false);

        receiverBox = new ComboBox<>();
        for (String name : mediator.getClientNames()) {
            if (!name.equals(client.getUsername())) {
                receiverBox.getItems().add(name);
            }
        }

        if (!receiverBox.getItems().isEmpty()) {
            receiverBox.setValue(receiverBox.getItems().get(0));
        }

        messageField = new TextField();
        messageField.setPromptText("Enter message");

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                new Label("Chat messages:"),
                messageArea,
                new Label("Send to:"),
                receiverBox,
                messageField,
                sendButton
        );

        Scene scene = new Scene(root, 350, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void sendMessage() {
        String receiver = receiverBox.getValue();
        String message = messageField.getText();

        if (receiver != null && !message.isEmpty()) {
            client.sendMessage(receiver, message);
            messageField.clear();
        }
    }

    public void displayMessage(String message) {
        messageArea.appendText(message + "\n");
    }
}