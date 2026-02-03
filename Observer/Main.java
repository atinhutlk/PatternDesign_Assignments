public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherStation station = new WeatherStation(-20, 30);

        station.setDaemon(true);

        Observer phone = new PhoneObserver();
        Observer tv = new TvObserver();
        Observer tablet = new TabletObserver();

        station.addObserver(phone);
        station.addObserver(tv);
        

        station.start();              
        Thread.sleep(12000);             

        System.out.println(" REMOVE TV OBSERVER ");
        station.removeObserver(tv);     

        Thread.sleep(12000);
        System.out.println(" ADD TABLET OBSERVER ");
        station.addObserver(tablet);

        Thread.sleep(12000);             
        System.out.println("\nMain ends.");
    }
}
