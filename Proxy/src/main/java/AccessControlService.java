import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private Set<String> allowed = new HashSet<>();

    private AccessControlService() {
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void allowAccess(String username, String documentId) {
        allowed.add(username + "-" + documentId);
    }

    public boolean isAllowed(String documentId, String username) {
        return allowed.contains(username + "-" + documentId);
    }
}