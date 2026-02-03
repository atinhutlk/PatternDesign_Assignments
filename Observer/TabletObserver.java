public class TabletObserver implements Observer {
    @Override
    public void update(int temp) {
        System.out.println("Tablet Display: Temp = " + temp + "°C");
    }
    
}
