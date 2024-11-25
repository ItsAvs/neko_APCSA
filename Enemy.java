import java.util.ArrayList;
import java.util.Random;

public abstract class Enemy {
    private String name;
    private int health;
    private ArrayList<Ability> abilities;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
        this.abilities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isDefeated() {
        return health <= 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " takes " + damage + " damage! Remaining health: " + health);
    }

    public void addAbility(String name, int damage, int cooldown) {
        abilities.add(new Ability(name, damage, cooldown));
    }

    public void makeMove(Player player) {
        Ability chosenAbility = decideAbility();
        if (chosenAbility != null) {
            System.out.println(name + " uses " + chosenAbility.getName() + "!");
            player.takeDamage(chosenAbility.getDamage());
            chosenAbility.use();
        } else {
            System.out.println(name + " has no abilities available this turn!");
        }
    }

    protected Ability decideAbility() {
        for (Ability ability : abilities) {
            if (ability.isAvailable()) {
                return ability;
            }
        }
        return null;
    }

    public void reduceCooldowns() {
        for (Ability ability : abilities) {
            ability.reduceCooldown();
        }
    }
}
