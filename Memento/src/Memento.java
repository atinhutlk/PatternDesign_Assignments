
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    private static final DateTimeFormatter HISTORY_TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

    private int[] options;
    private boolean isSelected;
    private LocalDateTime savedAt;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.savedAt = LocalDateTime.now();
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options.clone();
    }

    public boolean isSelected() {
        return isSelected;
    }

    public String getHistoryLabel() {
        return String.format("%s | colors=[%d, %d, %d], checkbox=%s",
                savedAt.format(HISTORY_TIME_FORMAT),
                options[0],
                options[1],
                options[2],
                isSelected ? "checked" : "unchecked");
    }
}