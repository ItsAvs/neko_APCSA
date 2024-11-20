public class Enemy extends NekoCharacter{
    private String name;
    private int attackPower;
    private int health;
    public Enemy(String characterName, int maxHealth, int attackPower){
        super(characterName, maxHealth);
        name = characterName;
        this.attackPower = attackPower;
        this.health = maxHealth;
    }
    
    public String getName(){
        return name;
    }

    public int getAttackPower(){
        return attackPower;
    }

    public void takeDamage(int damage){
        health -= damage;
    }
}
