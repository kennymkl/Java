package game_elements.weapons;

public class MagicalWeapon extends Weapon {

    public MagicalWeapon(String name) {
        this.initializeWeapon(name);
    }

    public int getRarity() {
        return this.rarity+1;
    }
}
