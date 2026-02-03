public class PhoneObserver implements Observer {
   
    @Override
    public void update(int temp) {
        System.out.println("Phone: Temp = " + temp + "°C");
    }
}
