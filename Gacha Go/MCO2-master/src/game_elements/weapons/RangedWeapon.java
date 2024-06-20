package game_elements.weapons;

public class RangedWeapon extends Weapon {
    private double criticalDamage;

    public RangedWeapon(String name) {
        this.initializeWeapon(name);
        this.criticalDamage = 1; // default value
    }

    public void hone() {
        this.criticalDamage += 0.2;
    }
}
