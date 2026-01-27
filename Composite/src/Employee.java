package src;
public class Employee extends Component {
    private final int salary;

    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void add(Component c) {
        throw new UnsupportedOperationException("Cannot add to an Employee.");
    }

    @Override
    public void remove(Component c) {
        throw new UnsupportedOperationException("Cannot remove from an Employee.");
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void display(int indent) {
        System.out.println(indent(indent) +
                "<employee name=\"" + name + "\" salary=\"" + salary + "\"/>");
    }
}
