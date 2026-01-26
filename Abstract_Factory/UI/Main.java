package UI;

import UI.Factory.AFactory;
import UI.Factory.BFactory;
import UI.Factory.UIFactory;

public class Main {
    public static void main(String[] args) {

        UIFactory factory = new AFactory();
        //UIFactory factory = new BFactory();
        Button button = factory.createButton("OK");
        TextField textField = factory.createTextField("username");
        Checkbox checkBox = factory.createCheckbox("Remember me");

        //Display default text
        System.out.println("FIRST DISPLAY");
        button.display();
        textField.display();
        checkBox.display();

        // Set new text and display one moreeeeee
        System.out.println("\nAFTER setText");
        button.setText("Submit");
        textField.setText("nhut@gmail.com");
        checkBox.setText("I agree");

        button.display();
        textField.display();
        checkBox.display();
    }
}
