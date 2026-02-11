public class MasterState implements State {
    @Override public String levelName() { return "Master"; }
    @Override public String actions() { return "(game ends)"; }

    @Override public void train(GameCharacter c) { }
    @Override public void meditate(GameCharacter c) { }
    @Override public void fight(GameCharacter c) { }
}
