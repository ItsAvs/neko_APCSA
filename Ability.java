import java.util.Random;

public class Ability {
    private String name;
    private int minDamage;
    private int maxDamage;
    private int cooldown;
    private int turnsLeft;
    private double failureChance;
    private Engine game;

    public Ability(String name, int minDamage, int maxDamage, int cooldown, double failureChance, Engine game) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.cooldown = cooldown;
        this.turnsLeft = 0;
        this.failureChance = failureChance;
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return turnsLeft == 0;
    }

    public int use() {
        if (turnsLeft > 0) {
            game.displayText(name + " is on cooldown for " + turnsLeft + " more turn(s)!");
            return -1; // ability cannot be used
        }

        Random random = new Random();
        if (random.nextDouble() < failureChance) {
            game.displayText(name + " failed!");
            return 0; // failed attack
        }

        // random damage lil bro
        int damage = random.nextInt(maxDamage - minDamage + 1) + minDamage;
        turnsLeft = cooldown; // cooldown
        return damage;
    }

    public void reduceCooldown() {
        if (turnsLeft > 0) {
            turnsLeft--;
        }
    }
}
