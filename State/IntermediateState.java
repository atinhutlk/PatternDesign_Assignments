public class IntermediateState implements State {
    @Override public String levelName() { return "Intermediate"; }
    @Override public String actions() { return "train, meditate"; }

    @Override
    public void train(GameCharacter c) {
        c.addExp(50);
        System.out.println("Train: +50 EXP");
        c.checkLevelUp();
    }

    @Override
    public void meditate(GameCharacter c) {
        c.addHp(25);
        System.out.println("Meditate: +25 HP");
    }

    @Override public void fight(GameCharacter c) { System.out.println("Not allowed."); }
}
