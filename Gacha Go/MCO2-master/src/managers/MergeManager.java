package managers;

import game_elements.gacha_characters.Character;
import game_elements.weapons.Weapon;

import java.util.ArrayList;

public class MergeManager {
    private ArrayList<Character> mergeCharacters;
    private ArrayList<Weapon> mergeWeapons;

// Constructors---+
    public MergeManager() {
        this.mergeCharacters = new ArrayList<Character>(3);
        this.mergeWeapons = new ArrayList<Weapon>(3);
    }

// Getters---+
    public int numCharacters() {
        return this.mergeCharacters.size();
    }
    public ArrayList<Character> allCharacters() {
        return this.mergeCharacters;
    }
    public int numWeapons() {
        return this.mergeWeapons.size();
    }
    public ArrayList<Weapon> allWeapons() {
        return this.mergeWeapons;
    }

// VALIDATION METHODS

    // Check if characters have the same name and rarity
    public boolean sameCharacters() {
        for (int i = 0; i < 2; i++){
            Character char1 = this.mergeCharacters.get(i);
            Character char2 = this.mergeCharacters.get(i+1);
            if (char1.getCharName().equals(char2.getCharName()) && char1.getRarity() == char2.getRarity()) {
            }
            else
                return false;
        }
        return true;
    }

    // Check if game_elements.weapons have the same name and rarity
    public boolean sameWeapons() {
        for (int i = 0; i < 2; i++){
            Weapon weapon1 = this.mergeWeapons.get(i);
            Weapon weapon2 = this.mergeWeapons.get(i+1);
      
            if (weapon1.getName().equals(weapon2.getName()) && weapon1.getRarity() == weapon2.getRarity()) {
            }
            else
                return false;
        }
        return true;
    }

// METHODS: Adding objects to merge list 

    // Receive character from player and makes sure rarity is not 5.
    public void receiveCharacter(Character select) {
        if (select.getRarity() >= 5) {
            System.out.println("ERROR: Rarity is already 5. Character cannot be deployed for merge.");
        }
        else {
            this.mergeCharacters.add(select);
        }
    }

    // Receive weapon from player and makes sure rarity is not 5.
    public void receiveWeapon(Weapon select) {
        if (select.getRarity() >= 5) {
            System.out.println("ERROR: Rarity is already 5. Weapon cannot be deployed for merge.");
        }
        else {
            this.mergeWeapons.add(select);
        }
    }
// METHODS: Merge Process 

    /* Method that removes game_elements.weapons that extra characters may have equipped
       Return value @returnList will be received by player.receiveManyWeapon() in the game method for merge
    */
    public ArrayList<Weapon> returnAllWeapons (){
        ArrayList<Weapon> returnList = new ArrayList<Weapon>(2);
        for (int i = 0; i < 2; i++) {
            Character extra = this.mergeCharacters.get(1);
            if (extra.hasWeapon())
                extra.unequipWeapon();
                returnList.add(extra.getWeapon());
        }
        return returnList;
    }

    // Increase target character's rarity
    // Returns upgraded target to be received by the player
    public Character charRarityUp() {
        Character target = this.mergeCharacters.get(0);
        target.rarityUp();
        return target;
    }

    // Increase target game_elements.weapons's rarity
    // Returns upgraded target be received by the player
    public Weapon weaponRarityUp() {
        Weapon target = this.mergeWeapons.get(0);
        target.rarityUp();
        return target;
    }


}

/*GAME METHOD FOR MERGE

public void mergeCharacters() {
        MergeManager charMerge = new MergeManager();
        int promptControl;

        // player add characters to merge list
        do {
            switch (promptControl = charMerge.numCharacters()) {
                case 0:
                    System.out.println("Choose a character to upgrade");
                    break;
                case 1:
                case 2:
                    System.out.println("Choose extra character to merge");
                    break;
                default:
                    System.out.println("Character cannot be merged anymore");
            }

            Character selectChar = player.selectCharacter();
            if (!charMerge.allCharacters().contains(selectChar))
                charMerge.receiveCharacter(selectChar);
            else
                System.out.println("ERROR: Character already selected\n");
        } while (charMerge.numCharacters() < 3);

        // remove characters in inventory
        for (Character inList:
             charMerge.allCharacters()) {
            this.player.removeCharacter(inList);
        };

        // manager evaluates merge success
        // return character/s to player
        if (charMerge.sameCharacters()) {
            this.player.receiveManyWeapon(charMerge.returnAllWeapons());
            this.player.receiveCharacter(charMerge.charRarityUp());
            System.out.println("Merge success!");
        }
        else {
            this.player.receiveManyChar(charMerge.allCharacters());
            System.out.println("Merge fail...");
        }

    }

    public void mergeWeapons() {
        MergeManager weaponMerge = new MergeManager();
        int promptControl;

        // Player add game_elements.weapons to merge list
        do {
            switch (promptControl = weaponMerge.numWeapons()) {
                case 0:
                    System.out.println("Choose a character to upgrade");
                    break;
                case 1:
                case 2:
                    System.out.println("Choose extra character to merge");
                    break;
                default:
                    System.out.println("Character cannot be merged anymore");
            }
            Weapon selectWeapon = this.player.selectWeapon();
            if (weaponMerge.allWeapons().contains(selectWeapon))
                weaponMerge.receiveWeapon(selectWeapon);
            else
                System.out.println("ERROR: Weapon already selected\n");

        } while (weaponMerge.numWeapons() < 3);

        // Remove game_elements.weapons in merge list from inventory
        for (Weapon inList:
                weaponMerge.allWeapons()) {
            this.player.removeWeapon(inList);
        };

        // Merge manager evaluates merge success
        // Return weapon/s to player
        if (weaponMerge.sameWeapons()) {
            this.player.receiveWeapon(weaponMerge.weaponRarityUp());
            System.out.println("Merge success!");
        }
        else {
            this.player.receiveManyWeapon(weaponMerge.allWeapons());
            System.out.println("Merge fail...");
        }
    }

*/
