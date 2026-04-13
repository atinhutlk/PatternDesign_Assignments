public class Demo {
    public static void main(String[] args) {
        SmartTV smartTv = new SmartTV();
        SmartRemote smartRemote = new SmartRemote(smartTv);

        smartRemote.togglePower();
        smartRemote.volumeUp();
        smartRemote.channelUp();
        smartRemote.voiceControl("Open YouTube");
        smartTv.browseInternet();
        smartRemote.togglePower();
    }
}