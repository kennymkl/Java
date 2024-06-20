package managers;

import game_elements.gacha_characters.Character;
import game_elements.weapons.BladedWeapon;
import game_elements.weapons.MagicalWeapon;
import game_elements.weapons.RangedWeapon;
import game_elements.weapons.Weapon;

public class EquipManager {
    private Character chosenCharacter;
    private Weapon chosenWeapon;

    private boolean isCompatible(Character character, Weapon weapon) {
        switch (character.getWeaponTag()) {
            case "Bladed":
                return weapon instanceof BladedWeapon;
            case "Ranged":
                return weapon instanceof RangedWeapon;
            default:
                return weapon instanceof MagicalWeapon;
        }
    }

    public Weapon returnWeapon() {
        if (this.chosenCharacter.hasWeapon())
            return this.chosenCharacter.unequipWeapon();
    }

    public void equip() {
        if(isCompatible(this.chosenCharacter, this.chosenWeapon))
            this.chosenCharacter.equip(this.chosenWeapon);
        else
            System.out.println(">>> "+this.chosenCharacter.getCharName()+" cannot hold this weapon.\n");
    }


}
