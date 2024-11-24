public class Nemo {

    private String characterName;
    private int maxHealth;
    private int health;
    private int damage;


    public Nemo(String characterName, int maxHealth) {
        this.characterName = characterName;
        this.maxHealth = maxHealth;
    }

    public void lapseBlue(Enemy opponent) {
        System.out.println(opponent.getName() + " uses Blue on " + opponent.getName() + " for " + damage + " damage!");
        opponent.takeDamage(damage);
    }

    public void reversalRed(Enemy opponent) {
        System.out.println(opponent.getName() + " uses Red on " + opponent.getName() + " for " + damage * 2 + " damage!");
        opponent.takeDamage(damage * 2);
    }

    public void hollowPurple(Enemy opponent) {
        System.out.println("Take the amplified and the reversal, then smash together those two different expressions of infinity to create and push out imaginary mass. Imaginary Technique: Hollow Purple");
        opponent.takeDamage(damage * 6);
    }

    public void reverseCursedTechnique() {
        health += maxHealth / 5;
    }

}
