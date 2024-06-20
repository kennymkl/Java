package managers;

import game_elements.gacha_characters.Character;
import game_elements.Resource;
import game_elements.weapons.Weapon;

import java.util.Scanner;

public class LevellingManager {
    private Character deployedCharacter;
    private Weapon deployedWeapon;

// Constructors

/* Levelling Manager can receive either a character or weapon from player.selectCharacter()
   or player.selectWeapon().
*/ 
    public LevellingManager(Character receiveCharacter) {
        this.deployedCharacter = receiveCharacter;
    }

    public LevellingManager(Weapon receiveWeapon) {
        this.deployedWeapon = receiveWeapon;
    }

/* VALIDATION METHODS: Used to make sures that the manager does not receive a maxed level
   character or weapon from the player in the game class
*/
    // Validates that character is not yet at level 100
    public boolean charCanLevelUp() {
         if (this.deployedCharacter.getLevel() >= 100) {
             System.out.println("ERROR: Character at maximum level");
             return false;
         } else
             return true;
    }

    // Validates that weapon is not yet level 50
    public boolean weaponCanLevelUp() {
        if (this.deployedWeapon.getLevel() >= 50) {
            System.out.println("ERROR: Weapon at maximum level");
            return false;
        } else
            return true;
    }

/* Method that asks user how much to level up the character or weapon
*/
    private int getLevelCost() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to level up: ");
        int cost = sc.nextInt();

        while (cost < 0) {
            System.out.println("ERROR: Input must be a positive integer");
            System.out.print("Enter amount to level up: ");
            cost = sc.nextInt();
        }
        return cost;
    }

/* LEVEL UP Methods: Parameter @bank is the player's resource inventory
*/
    public void charLevelUp(Resource bank) {

        int addedLevel = this.getLevelCost();

        // If player has enough resources
        if (bank.getAmount() >= addedLevel) {
            // If user inputs a number that will increase level over the maximum
            if (this.deployedCharacter.getLevel() + addedLevel > 100) {
                addedLevel = 100 - this.deployedCharacter.getLevel();
                System.out.println("Max level reached. Extra resources returned to inventory.");
            }
                
            bank.consume(addedLevel); // Consumer resources
            this.deployedCharacter.levelUp(addedLevel); // Level up character
            System.out.print(">>> SUCCESS! "+this.deployedCharacter.getCharName()+" is now level "+this.deployedCharacter.getLevel());
        }
        else
            System.out.println("ERROR: Level up failed. Not enough resources!");
    }

    public void weaponLevelUp(Resource bank) {
        int addedLevel = this.getLevelCost();
        if (bank.getAmount() >= addedLevel) {
            if (this.deployedWeapon.getLevel() + addedLevel > 50) {
               addedLevel = 50 - this.deployedWeapon.getLevel();
               System.out.println("Max level reached. Extra resources returned to inventory.");
               
            }

            bank.consume(addedLevel);
            this.deployedWeapon.levelUp(addedLevel);
            System.out.print(">>> SUCCESS! "+this.deployedWeapon.getName()+" is now level "+this.deployedWeapon.getLevel());
        }
        else
            System.out.println("ERROR: Level up failed. Not enough resources!");
    }

}
