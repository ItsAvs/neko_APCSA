import java.util.ArrayList;
import java.util.Random;

public class Enemy {
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

    public void addAbility(String name, int minDamage, int maxDamage, int cooldown, double failureChance) {
        abilities.add(new Ability(name, minDamage, maxDamage, cooldown, failureChance));
    }

    public void makeMove(Player player) {
        Random random = new Random();
        Ability chosenAbility = abilities.get(random.nextInt(abilities.size()));

        System.out.println(name + " uses " + chosenAbility.getName() + "!");
        int damage = chosenAbility.use();

        if (damage == -1) {
            System.out.println(name + " skips the turn because of cooldown.");
        } else if (damage > 0) {
            player.takeDamage(damage);
        }
    }

    public void reduceCooldowns() {
        for (Ability ability : abilities) {
            ability.reduceCooldown();
        }
    }
}
