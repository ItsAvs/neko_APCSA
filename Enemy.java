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

    public int getHealth(){
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " takes " + damage + " damage! Remaining health: " + health);
    }

    public void addAbility(String name, int minDamage, int maxDamage, int cooldown, double failureChance) {
        abilities.add(new Ability(name, minDamage, maxDamage, cooldown, failureChance));
    }

    public int bossStage() {
        int stage = 0;
        if (health <= health * 0.7) {
            stage = 1;
        }
        if (health <= health * 0.5) {
            stage = 2;
        }
        return stage;
    }

    public void makeMove(Player player) {
        Random random = new Random();

        int startIndex = 0;
        int endIndex = 2;

        if (bossStage() == 1) {
            startIndex = 3;
            endIndex = 5;
        }
        if (bossStage() == 2) {
            startIndex = 6;
            endIndex = 8;
        }
    
        Ability chosenAbility = null;
        int damage = -1;
    
        do {
            int randomIndex = random.nextInt(endIndex - startIndex + 1) + startIndex;
            chosenAbility = abilities.get(randomIndex);
            damage = chosenAbility.use();
        } while (damage == -1); // Repeat if the ability is on cooldown
    
        System.out.println(name + " uses " + chosenAbility.getName() + "!");
        
        if (damage > 0) {
            player.takeDamage(damage);
        }
    }
    
    

    public void reduceCooldowns() {
        for (Ability ability : abilities) {
            ability.reduceCooldown();
        }
    }
}
