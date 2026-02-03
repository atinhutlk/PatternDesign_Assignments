public class TvObserver implements Observer {
    @Override
    public void update(int temp) {
        System.out.println("TV: Current temp = " + temp + "°C");
    }
}
