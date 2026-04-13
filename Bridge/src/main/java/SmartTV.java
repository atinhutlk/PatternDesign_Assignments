public class SmartTV implements SmartDevice {
    private boolean enabled;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
        System.out.println("Power on");
    }

    @Override
    public void disable() {
        enabled = false;
        System.out.println("Power off");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
        System.out.println("Volume set to " + volume);
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("Channel set to " + this.channel);
    }

    @Override
    public void browseInternet() {
        System.out.println("Browsing: https://refactoring.guru");
    }
}