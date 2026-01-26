package UI.StyleA;

import UI.TextField;
public class TextFieldA extends TextField {
    public TextFieldA(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("[__" + text + "__]");
    }
}
