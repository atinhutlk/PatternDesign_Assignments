import java.time.LocalDate;
import java.util.HashMap;

public class Library {
    private HashMap<String, IDocument> documents = new HashMap<>();

    public void addUnprotectedDocument(String id, LocalDate date, String content) {
        documents.put(id, new Document(id, date, content));
    }

    public void addProtectedDocument(String id, LocalDate date, String content) {
        Document realDoc = new Document(id, date, content);
        documents.put(id, new DocumentProxy(realDoc));
    }

    public IDocument getDocument(String id) {
        return documents.get(id);
    }
}