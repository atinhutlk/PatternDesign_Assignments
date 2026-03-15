public abstract class FeedbackHandler {
    protected FeedbackHandler nextHandler;

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract String handle(Message message);
}