import java.time.LocalDate;

class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService access = AccessControlService.getInstance();

        User alice = new User("alice");
        User bob = new User("bob");

        library.addUnprotectedDocument("doc1", LocalDate.now(), "This is public content");
        library.addProtectedDocument("doc2", LocalDate.now(), "This is secret content");

        access.allowAccess("alice", "doc2");

        IDocument doc1 = library.getDocument("doc1");
        IDocument doc2 = library.getDocument("doc2");

        System.out.println("doc1 date: " + doc1.getCreationDate());
        System.out.println("Alice reads doc1: " + doc1.getContent(alice));

        System.out.println("doc2 date: " + doc2.getCreationDate());
        System.out.println("Alice reads doc2: " + doc2.getContent(alice));

        try {
            System.out.println("Bob reads doc2: " + doc2.getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println("Bob cannot read doc2");
        }
    }
}