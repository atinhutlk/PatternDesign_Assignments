package chatapp;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChatMediator mediator = new ChatMediator();

        ChatClient alice = new ChatClient("Alice", mediator);
        ChatClient bob = new ChatClient("Bob", mediator);
        ChatClient charlie = new ChatClient("Charlie", mediator);

        mediator.registerClient(alice);
        mediator.registerClient(bob);
        mediator.registerClient(charlie);

        ChatClientController aliceController = new ChatClientController(alice, mediator);
        ChatClientController bobController = new ChatClientController(bob, mediator);
        ChatClientController charlieController = new ChatClientController(charlie, mediator);

        alice.setController(aliceController);
        bob.setController(bobController);
        charlie.setController(charlieController);

        aliceController.showWindow();
        bobController.showWindow();
        charlieController.showWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}