
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> undoHistory;
    private List<IMemento> redoHistory;
    private List<IMemento> stateTimeline;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.undoHistory = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
        this.stateTimeline = new ArrayList<>();
        stateTimeline.add(model.createMemento());
    }

    public void setOption(int optionNumber, int choice) {
        saveForUndo();
        model.setOption(optionNumber, choice);
        recordCurrentState();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveForUndo();
        model.setIsSelected(isSelected);
        recordCurrentState();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!undoHistory.isEmpty()) {
            redoHistory.add(model.createMemento());
            IMemento previousState = undoHistory.remove(undoHistory.size() - 1);
            model.restoreState(previousState);
            recordCurrentState();
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            undoHistory.add(model.createMemento());
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(nextState);
            recordCurrentState();
            gui.updateGui();
        }
    }

    public List<String> getHistoryLabels() {
        List<String> labels = new ArrayList<>();
        for (int i = 0; i < stateTimeline.size(); i++) {
            labels.add((i + 1) + ". " + stateTimeline.get(i).getHistoryLabel());
        }
        return Collections.unmodifiableList(labels);
    }

    public void restoreFromHistoryIndex(int index) {
        if (index < 0 || index >= stateTimeline.size()) {
            return;
        }

        saveForUndo();
        model.restoreState(stateTimeline.get(index));
        recordCurrentState();
        gui.updateGui();
    }

    private void saveForUndo() {
        undoHistory.add(model.createMemento());
        redoHistory.clear();
    }

    private void recordCurrentState() {
        stateTimeline.add(model.createMemento());
        gui.refreshHistoryWindow();
    }
}