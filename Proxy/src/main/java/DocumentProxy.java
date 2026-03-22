import java.time.LocalDate;

public class DocumentProxy implements IDocument {
    private Document realDocument;
    private AccessControlService accessControl;

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
        this.accessControl = AccessControlService.getInstance();
    }

    public String getDocumentId() {
        return realDocument.getDocumentId();
    }

    public LocalDate getCreationDate() {
        return realDocument.getCreationDate();
    }

    public String getContent(User user) {
        if (accessControl.isAllowed(realDocument.getDocumentId(), user.getUsername())) {
            return realDocument.getContent(user);
        }
        throw new AccessDeniedException("Access denied!");
    }
}