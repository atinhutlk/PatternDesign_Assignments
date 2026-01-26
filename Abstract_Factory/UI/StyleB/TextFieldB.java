package UI.StyleB;

import UI.TextField;
public class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }

     @Override
    public void display() {
        System.out.println("{__" + text + "__}");
    }
}