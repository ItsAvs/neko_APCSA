public class Player {

    private String name;
    private int health;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public abstract void move(Player gojo);

    public boolean isDefeated() {
        return health <= 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

}