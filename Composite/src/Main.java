package src;
public class Main {
    public static void main(String[] args) {
        Organization org = new Organization("MyCompany");

        Department it = new Department("IT");
        Department dev = new Department("Development");
        Department hr = new Department("HR");

        Employee nhut = new Employee("Nhut", 3000);
        Employee niko = new Employee("Niko", 2800);
        Employee hegi = new Employee("Hegi", 3500);
        Employee toni = new Employee("Toni", 2500); 
        Employee alex = new Employee("Alex", 4000);
        
        it.add(nhut);
        it.add(niko);

        dev.add(hegi);
        it.add(dev);

        hr.add(toni);

        org.add(it);
        org.add(hr);

        System.out.println("Total salary = " + org.getSalary());

        System.out.println("\n--- XML ---");
        org.display(0); 

        it.remove(niko);
        hr.add(alex);
        
        System.out.println("\n================================");
        System.out.println("\nAfter changes:");
        System.out.println("Total salary = " + org.getSalary());
        System.out.println("\n--- XML ---");
        org.display(0); 

}};
