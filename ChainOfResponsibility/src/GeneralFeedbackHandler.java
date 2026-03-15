public class GeneralFeedbackHandler extends FeedbackHandler {
    @Override
    public String handle(Message message) {
        if (message.getMessageType() == MessageType.GENERAL_FEEDBACK) {
            return "General feedback handled for: " + message.getSenderEmail();
        } else if (nextHandler != null) {
            return nextHandler.handle(message);
        }
        return "No handler found.";
    }
}