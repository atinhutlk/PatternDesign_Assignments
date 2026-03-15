public class ContactRequestHandler extends FeedbackHandler {
    @Override
    public String handle(Message message) {
        if (message.getMessageType() == MessageType.CONTACT_REQUEST) {
            return "Contact request handled for: " + message.getSenderEmail();
        } else if (nextHandler != null) {
            return nextHandler.handle(message);
        }
        return "No handler found.";
    }
}