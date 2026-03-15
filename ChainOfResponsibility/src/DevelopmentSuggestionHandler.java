public class DevelopmentSuggestionHandler extends FeedbackHandler {
    @Override
    public String handle(Message message) {
        if (message.getMessageType() == MessageType.DEVELOPMENT_SUGGESTION) {
            return "Development suggestion handled for: " + message.getSenderEmail();
        } else if (nextHandler != null) {
            return nextHandler.handle(message);
        }
        return "No handler found.";
    }
}