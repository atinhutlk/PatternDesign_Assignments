public class ExpertState implements State {
    @Override public String levelName() { return "Expert"; }
    @Override public String actions() { return "train, meditate, fight"; }

    @Override
    public void train(GameCharacter c) {
        c.addExp(50);
        System.out.println("Train: +50 EXP");
        c.checkLevelUp();
    }

    @Override
    public void meditate(GameCharacter c) {
        c.addHp(20);
        System.out.println("Meditate: +20 HP");
    }

    @Override
    public void fight(GameCharacter c) {
        c.addHp(-30);
        c.addExp(50);
        System.out.println("Fight: -30 HP, +50 EXP");
        c.checkLevelUp();
    }
}
