public class Rosie extends Enemy {
    public Rosie() {
        super("Rosie", 100);
        addAbility("Scratch", 5, 15, 1, 0.1);
        addAbility("Pounce", 10, 20, 2, 0.15);
        addAbility("Growl", 0, 10, 0, 0.05);
    }
}