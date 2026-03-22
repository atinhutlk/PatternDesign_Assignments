import java.time.LocalDate;

public class Document implements IDocument {
    private String documentId;
    private LocalDate creationDate;
    private String content;

    public Document(String documentId, LocalDate creationDate, String content) {
        this.documentId = documentId;
        this.creationDate = creationDate;
        this.content = content;
    }

    public String getDocumentId() {
        return documentId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getContent(User user) {
        return content;
    }
}