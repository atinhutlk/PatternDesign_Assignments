package UI.Factory;

import UI.StyleB.ButtonB;
import UI.StyleB.TextFieldB;
import UI.StyleB.CheckboxB;
import UI.TextField;
import UI.Checkbox;
import UI.Button;

public class BFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldB(text);
    }
    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxB(text);
    }
}