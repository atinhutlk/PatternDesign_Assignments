package UI.Factory;

import UI.Button;
import UI.Checkbox;
import UI.TextField;

public abstract class UIFactory {
    public abstract Button createButton(String text);
    public abstract TextField createTextField(String text);
    public abstract Checkbox createCheckbox(String text);
}
