package src;
import java.util.ArrayList;
    
public class Department extends Component {
     public Department(String name){
        super(name);
    }
    ArrayList<Component> components = new ArrayList<>();
    @Override
    public void add(Component c) {
        components.add(c);
    }

    @Override
    public void remove(Component c) {
        components.remove(c);
    }

    @Override
    public void display(int indent) {
        System.out.println(indent(indent) + "<department name=\"" + name + "\">");
        for (Component c : components) c.display(indent + 1);
        System.out.println(indent(indent) + "</department>");
    }

    @Override
    public int getSalary() {
        int totalSalary = 0;
        for (Component c : components) {
            totalSalary += c.getSalary();
        }
        return totalSalary;
    }
    
}
