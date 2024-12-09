import java.util.ArrayList;
import java.util.Random;

public class Enemy {
    private String name;
    private int health;
    private ArrayList<Ability> abilities;
    private Engine game;

    public Enemy(String name, int health, Engine game) {
        this.name = name;
        this.health = health;
        this.game = game;
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
        abilities.add(new Ability(name, minDamage, maxDamage, cooldown, failureChance, game));
    }

    public int bossStage() {
        int stage = 0;
        if (health <= health * 0.5) {
            stage = 1;
        }
        return stage;
    }

    public String makeMove(Player player, Engine game) {
        Random random = new Random();

        int startIndex = 0;
        int endIndex = 2;

        if (bossStage() == 1) {
            startIndex = 3;
            endIndex = 5;
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

        return chosenAbility.getName();
    }
    
    

    public void reduceCooldowns() {
        for (Ability ability : abilities) {
            ability.reduceCooldown();
        }
    }
}
