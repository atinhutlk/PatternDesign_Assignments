public class GameCharacter {
    private final String name;
    private int exp;
    private int hp;
    private State state;

    // EXP needed to level up
    private static final int TO_INTERMEDIATE = 100;
    private static final int TO_EXPERT = 200;
    private static final int TO_MASTER = 300;

    public GameCharacter(String name) {
        this.name = name;
        this.exp = 0;
        this.hp = 100;
        this.state = new NoviceState();
    }

    public void printStatus() {
        System.out.println("Name: " + name
                + " | Level: " + state.levelName()
                + " | EXP: " + exp
                + " | HP: " + hp);
        System.out.println("Actions: " + state.actions());
    }

    public void train() { state.train(this); }
    public void meditate() { state.meditate(this); }
    public void fight() { state.fight(this); }

    public boolean isMaster() {
        return state instanceof MasterState;
    }

    // used by states
    public void addExp(int amount) { exp += amount; }
    public void addHp(int amount) { hp += amount; }
    public int getExp() { return exp; }

    public void checkLevelUp() {
        if (exp >= TO_MASTER) state = new MasterState();
        else if (exp >= TO_EXPERT) state = new ExpertState();
        else if (exp >= TO_INTERMEDIATE) state = new IntermediateState();
    }
}
