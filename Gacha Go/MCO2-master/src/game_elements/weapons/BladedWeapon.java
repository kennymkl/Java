package game_elements.weapons;

public class BladedWeapon extends Weapon {

    public BladedWeapon() {
    }
    public BladedWeapon(String name) {
        this.initializeWeapon(name);
    }
    // Override original final power method
    public double finalPower() {
        return this.finalPower() + 10 * (double) this.getRarity();
    }
}

