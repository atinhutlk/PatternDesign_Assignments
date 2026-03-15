public class CompensationHandler extends FeedbackHandler {
    @Override
    public String handle(Message message) {
        if (message.getMessageType() == MessageType.COMPENSATION_CLAIM) {
            return "Compensation claim handled for: " + message.getSenderEmail();
        } else if (nextHandler != null) {
            return nextHandler.handle(message);
        }
        return "No handler found.";
    }
}