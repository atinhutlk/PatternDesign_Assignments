import java.util.*;

public class WeatherStation extends Thread {
    private final List<Observer> observers = new ArrayList<>();
    private final Random random = new Random();

    private int temp;
    private final int minTemp;
    private final int maxTemp;

    // Initial random temperature
    public WeatherStation(int minTemp, int maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.temp = random.nextInt(maxTemp - minTemp + 1) + minTemp;
    }

    
    public synchronized void addObserver(Observer o) {
        observers.add(o);
    }

    public synchronized void removeObserver(Observer o) {
        observers.remove(o);
    }

    private void notifyObservers() {
        //snapshot of observers to avoid concurrent modification
        List<Observer> copy;
        synchronized (this) {
            copy = new ArrayList<>(observers);
        }

        for (Observer o : copy) {
            o.update(temp);
        }
    }

    private void changeTemp() {
        int delta = random.nextBoolean() ? 2 : -3; 
        int newTemp = temp + delta;

        if (newTemp < minTemp) newTemp = minTemp;
        if (newTemp > maxTemp) newTemp = maxTemp;

        temp = newTemp;
    }

   
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000); //2s
                changeTemp();
                notifyObservers();
            } catch (InterruptedException e) {
            }
        }
    }
}