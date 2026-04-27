package chatapp;

public class ChatClient {

    private String username;
    private ChatMediator mediator;
    private ChatClientController controller;

    public ChatClient(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
    }

    public String getUsername() {
        return username;
    }

    public void setController(ChatClientController controller) {
        this.controller = controller;
    }

    public void sendMessage(String receiver, String message) {
        mediator.sendMessage(username, receiver, message);
    }

    public void receiveMessage(String sender, String message) {
        controller.displayMessage("From " + sender + ": " + message);
    }

    public void showSentMessage(String receiver, String message) {
        controller.displayMessage("To " + receiver + ": " + message);
    }
}