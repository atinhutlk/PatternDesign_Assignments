package UI.Factory;

import UI.Button;
import UI.StyleA.ButtonA;
import UI.StyleA.TextFieldA;
import UI.StyleA.CheckboxA;
import UI.TextField;
import UI.Checkbox;

public class AFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }
    
}
