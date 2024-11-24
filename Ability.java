public class Ability {
    private String name;
    private int damage;
    private int cooldown;
    private int turnsLeft;

    public Ability(String name, int damage, int cooldown) {
        this.name = name;
        this.damage = damage;
        this.cooldown = cooldown;
        this.turnsLeft = 0;
    }

    public boolean isAvailable() {
        return turnsLeft == 0;
    }

    public void use() {
        turnsLeft = cooldown;
    }

    public void reduceCooldown() {
        if (turnsLeft > 0) {
            turnsLeft--;
        }
    }
}
