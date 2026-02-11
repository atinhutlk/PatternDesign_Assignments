public interface State {
    String levelName();
    String actions();

    void train(GameCharacter c);
    void meditate(GameCharacter c);
    void fight(GameCharacter c);
}
