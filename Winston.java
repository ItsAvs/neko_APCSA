public class Winston extends Enemy {
    public Winston() {
        super("Winston", 120);
        addAbility("Bite", 15, 25, 2, 0.2);
        addAbility("Tail Whip", 10, 15, 1, 0.1);
        addAbility("Intimidate", 0, 10, 0, 0.05);
    }
}