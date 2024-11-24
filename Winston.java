public class Winston {
    private String characterName;
    private int maxHealth;


    public Winston(String characterName, int maxHealth) {
        this.characterName = characterName;
        this.maxHealth = maxHealth;
        //example for brandon ...

    }

    public void attack(Enemy opponent) {
        System.out.println(opponent.getName() + " attacks " + opponent.getName() + " for " + opponent.getAttackPower() + " damage!");
        opponent.takeDamage(opponent.getAttackPower());
    }

    public void specialMove(Enemy opponent) {
        int specialDamage = opponent.getAttackPower() * 2;
        System.out.println(opponent.getName() + " uses a special move on " + opponent.getName() + " for " + specialDamage + " damage!");
        opponent.takeDamage(specialDamage);
    }

}
