public class Winston extends NekoCharacter {

    public Winston(String characterName, int maxHealth, int attackPower) {
        super(characterName, maxHealth, attackPower);
    }

    @Override
    public void attack(NekoFighter opponent) {
        System.out.println(getName() + " attacks " + opponent.getName() + " for " + getAttackPower() + " damage!");
        opponent.takeDamage(getAttackPower());
    }

    public void specialMove(NekoFighter opponent) {
        int specialDamage = getAttackPower() * 2;
        System.out.println(getName() + " uses a special move on " + opponent.getName() + " for " + specialDamage + " damage!");
        opponent.takeDamage(specialDamage);
    }

    public static void main(String[] args) {
        Winston cat = new Winston("Winston", 10, 3, 0, 0);
        Winston opponent = new Winston("Opponent", 10, 2, 1, 1);
        cat.attack(opponent);
        cat.specialMove(opponent);
        System.out.println(opponent.getName() + " has " + opponent.getHealth() + " health left.");
    }
}
