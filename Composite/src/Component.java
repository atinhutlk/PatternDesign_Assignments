package src;
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component c);
    public abstract void remove(Component c);

    public abstract int getSalary();

    public abstract void display(int indent);

    protected String indent(int n) {
        return "  ".repeat(Math.max(0, n));
    }
}
