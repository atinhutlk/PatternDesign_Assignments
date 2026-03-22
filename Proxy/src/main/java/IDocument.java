import java.time.LocalDate;

public interface IDocument {
    String getDocumentId();
    LocalDate getCreationDate();
    String getContent(User user);
}