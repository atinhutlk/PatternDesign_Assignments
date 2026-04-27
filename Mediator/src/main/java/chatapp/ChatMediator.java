package chatapp;

import java.util.HashMap;
import java.util.Map;

public class ChatMediator {

    private Map<String, ChatClient> clients = new HashMap<>();

    public void registerClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }

    public void sendMessage(String sender, String receiver, String message) {
        ChatClient receiverClient = clients.get(receiver);

        if (receiverClient != null) {
            receiverClient.receiveMessage(sender, message);
        }

        ChatClient senderClient = clients.get(sender);
        if (senderClient != null) {
            senderClient.showSentMessage(receiver, message);
        }
    }

    public String[] getClientNames() {
        return clients.keySet().toArray(new String[0]);
    }
}