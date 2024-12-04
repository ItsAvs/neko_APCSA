public class Luna extends Enemy {
    public Luna() {
        super("Luna", 150);
        addAbility("Hiss", 10, 20, 1, 0.1);
        addAbility("Shadow Leap", 20, 30, 3, 0.25);
        addAbility("Claw", 15, 25, 2, 0.2);
    }
}
