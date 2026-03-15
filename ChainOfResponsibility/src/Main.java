public class Main {
    public static void main(String[] args) {
        FeedbackHandler compensationHandler = new CompensationHandler();
        FeedbackHandler contactHandler = new ContactRequestHandler();
        FeedbackHandler suggestionHandler = new DevelopmentSuggestionHandler();
        FeedbackHandler generalHandler = new GeneralFeedbackHandler();

        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalHandler);

        Message m1 = new Message(MessageType.COMPENSATION_CLAIM,
                "My product was broken.",
                "a@gmail.com");

        Message m2 = new Message(MessageType.CONTACT_REQUEST,
                "Please contact me tomorrow.",
                "b@gmail.com");

        Message m3 = new Message(MessageType.DEVELOPMENT_SUGGESTION,
                "Please add dark mode.",
                "c@gmail.com");

        Message m4 = new Message(MessageType.GENERAL_FEEDBACK,
                "Your service was very good.",
                "d@gmail.com");

        System.out.println(compensationHandler.handle(m1));
        System.out.println(compensationHandler.handle(m2));
        System.out.println(compensationHandler.handle(m3));
        System.out.println(compensationHandler.handle(m4));
    }
}