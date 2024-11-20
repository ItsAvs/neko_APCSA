public class Winston extends NekoCharacter {

    public Winston(String characterName, int maxHealth) {
        super(characterName, maxHealth);

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
