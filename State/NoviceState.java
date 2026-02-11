public class NoviceState implements State {
    @Override public String levelName() { return "Novice"; }
    @Override public String actions() { return "train"; }

    @Override
    public void train(GameCharacter c) {
        c.addExp(50);
        System.out.println("Train: +50 EXP");
        c.checkLevelUp();
    }

    @Override public void meditate(GameCharacter c) { System.out.println("Not allowed."); }
    @Override public void fight(GameCharacter c) { System.out.println("Not allowed."); }
}
