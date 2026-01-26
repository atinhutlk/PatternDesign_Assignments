package UI.StyleB;

public class ButtonB extends UI.Button {
    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("<< " + text + " >>");
    }
    
}
