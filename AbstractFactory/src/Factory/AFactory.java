package Factory;

import UI.Button;
import StyleA.ButtonA;
import StyleA.TextFieldA;
import StyleA.CheckboxA;
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