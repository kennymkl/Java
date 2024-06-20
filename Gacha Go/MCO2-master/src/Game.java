/*
Game class responsibilities:

[General]
-responsible for the while loop to be run throughout the game
-calling methods from other classes that are its composition
-calls mainGameWindow for display


[gachaMachine]
-would be the one to confirm purchase before proceeding to gachaMachine
-
-call the resource class'method within player1 to consume

[Adventure]
-run the goAdventure (Character, Character, Map); method
-call resource class in player and links with adventure earnings (i.e. value returned by goAdventure method)

[Inventory & Map Setting]
-open list of maps
-allow player to access it through method setMap
-includes merging and levelling capabilities

[facilitates merging]
1. selectCharacter want to merge on
2. use MergeManager methods from the class

[facilitates Levelling]
1.selectCharacter want to levelup
2. use LevellingManager methods from the class

[Design]
-has different segments of the game split into methods
-methods are included in one method (i.e. start()-> this will be the only one called by the main/driver class)




*/

import game_elements.gacha_characters.Character;
import game_elements.GachaMachine;
import game_elements.Resource;
import managers.Adventure;
import managers.LevellingManager;
import managers.MergeManager;
import game_elements.weapons.Weapon;

import java.util.Scanner;

public class Game {
    private Player objPlayer1;
    public Game ()
    {
        this.objPlayer1= new Player ();


    }

    public void gameStart()
    {
        //--------NEW GAME-----------------------------------------
        Scanner scanObj = new Scanner(System.in); //Shorten scan nextLine

        Window window1 = new Window();
        window1.displayBegin();

        objPlayer1.setResourceInventory(new Resource (scanObj.nextLine()));

//-----------MENU------------------------------------------

        boolean mainDone = false;

        while (!mainDone) {
            window1.displayMenu();
            System.out.println("Resources: "+ objPlayer1.getResourceInventory().getAmount());
            String mainSelect = scanObj.next();
            switch (mainSelect) { //.next()
                case "I":
                case "i":
                    window1.displayInvMapSettings();
                    this.invMapSettings(window1);
                    //inventory & map Setting
                    break;
                case "R":
                case "r":
                    window1.displayRoll();
                    this.gameGacha();
                    break;
                // gacha roll
                case "P":
                case "p":
                {
                    window1.displayAdventure();
                    this.adventureBegin();
                    // adventure
                    break;
                }
                case "X":
                case "x":
                    mainDone = true;
                    break;
                // restart
                default:
                    System.out.println("ERROR: Invalid input");
            }
        }


//---------------------------------------------------------
    }//<-----End bracket for start


//----SUPPORTING METHODS () :---------------------------------

    private String getInput(int lowerLimit, int upperLimit) {
        Scanner select = new Scanner (System.in);
        String number = select.next();

        while (number.compareTo(String.valueOf(lowerLimit)) < 0 || number.compareTo(String.valueOf(upperLimit)) > 0) {
            System.out.println("ERROR: Invalid input");
            System.out.print(">>> Input: ");
            number = select.next();
        }

        return number;
    }

    //class to be run when beginning an adventure
    private void adventureBegin() {
        boolean adventureDone = false;
        Scanner scanObj = new Scanner(System.in);
        while (!adventureDone)
        {
            String adventureChoice = scanObj.next();
            switch (adventureChoice)
            {
                case "1":
                {
                    this.gameAdventure();
                }
                adventureDone = true;
                break;
                case "2":
                {
                    adventureDone = true;
                }
                break;
                default:
                    System.out.println("ERROR: Invalid input");
            }
        }

    }

    //class to be run for the inventory & map setting access
    public void invMapSettings(Window window1) {
        String invMapSelect;
        String subSelect;

        do {
            System.out.print("\nChoose from Map and Inventory Settings: ");
            switch (invMapSelect = this.getInput(1,6)) {
                case "1": // View Current Inventory

                    objPlayer1.displayCharacters();
                    objPlayer1.displayWeapons();

                    System.out.println("");

                    break;

                case "2": // Equip a Weapon
                    window1.displayEquipOptions();
                    do {
                        System.out.print("\nChoose from the Equip Options: ");
                        switch(subSelect = getInput(1,3)) {
                            case "1":
                                this.equipWeapon();
                                break;
                            case "2":
                                this.unequipWeapon();
                                break;
                            case "3":
                                break;
                            default:
                                System.out.println("ERROR: Invalid input");

                        }

                    } while (!subSelect.equals("3"));

                    break;

                case "3": // Select Map

                    window1.displayMapOptions();
                    objPlayer1.selectMap();

                    break;

                case "4": // Merge methods

                    window1.displayMergeOptions();
                    do {
                        System.out.print("\nChoose from Merge Center: ");
                        switch(subSelect = getInput(1,3)) {
                            case "1":
                                if (objPlayer1.getCharacterInventory().size() < 3)
                                    System.out.println("ERROR: Not enough characters to merge in inventory");
                                else
                                    this.mergeCharacters();
                                break;
                            case "2":
                                if (objPlayer1.getWeaponInventory().size() < 3)
                                    System.out.println("ERROR: Not enough game_elements.weapons to merge in inventory");
                                else
                                    this.mergeWeapons();
                                break;
                            case "3":
                                break;
                            default:
                                System.out.println("ERROR: Invalid input");
                        }
                    } while (!subSelect.equals("3"));

                    break;

                case "5": // Levelling methods
                    window1.displayLevelOptions();
                    do {
                        System.out.print("\nChoose from Levelling Center: ");
                        switch(subSelect = getInput(1,3)) {
                            case "1":
                                if (objPlayer1.getCharacterInventory().size() == 0)
                                    System.out.println("ERROR: No character in the inventory");
                                else
                                    this.levelUpCharacter();
                                break;
                            case "2":
                                if (objPlayer1.getWeaponInventory().size() == 0)
                                    System.out.println("ERROR: No weapon in the inventory");
                                else
                                    this.levelUpWeapon();
                                break;
                            case "3":
                                break;
                            default:
                                System.out.println("ERROR: Invalid input");
                        }
                    } while (!subSelect.equals("3"));
                    break;
                case "6": // Cancel
                    System.out.println(">>>Returning to Main Menu");
                    break;
                default:
                    System.out.println("ERROR: Invalid input");
            }
        } while (!invMapSelect.equals("6"));

    }
    private void equipWeapon() {
        if (objPlayer1.getWeaponInventory().size() == 0) {
            System.out.println("ERROR: No weapon to equip in inventory");
        }
        else if (objPlayer1.getCharacterInventory().size() == 0) {
            System.out.println("ERROR: No character in inventory");
        }
        else {
            // Choose a weapon to equip and remove from inventory
            objPlayer1.displayWeapons();
            System.out.println("\nChoose a weapon to equip");
            Weapon toEquip = objPlayer1.selectWeapon();

            //Remove weapon from player inventory
            objPlayer1.removeWeapon(toEquip);
            System.out.println(">>> "+toEquip.getName()+" removed from inventory");

            // Choose a character who will equip the weapon
            objPlayer1.displayCharacters();
            System.out.println("\nChoose character to equip " + toEquip.getName());
            Character character = objPlayer1.selectCharacter();

            // If character already has a weapon, unequip then return to player inventory
            if (character.hasWeapon()) {
                Weapon unequippedWeapon = character.unequipWeapon();
                objPlayer1.receiveWeapon(unequippedWeapon);
                System.out.println(unequippedWeapon.getName()+" returned to inventory");
            }
            // Equip weapon to character
            character.equip(toEquip);
            System.out.println(">>> "+toEquip.getName()+" equipped to "+character.getCharName());
        }

    }

    private void unequipWeapon(){
        if (this.objPlayer1.getCharacterInventory().size() == 0) {
            System.out.println("ERROR: No character in inventory");
        } //spotted
        else {
            objPlayer1.displayCharacters();
            System.out.println("\nChoose character to remove weapon from");
            Character selectedChar = objPlayer1.selectCharacter();
            // If character already has a weapon, unequip then return to player inventory
            if (selectedChar.hasWeapon()) {
                objPlayer1.receiveWeapon(selectedChar.unequipWeapon());
            }
            else
                System.out.println("Character does not have a weapon");
        }
    }

    private void gameGacha() //<----Gacha method which includes all calls for the managing of storing returned values of gacha pull related methods and the player class' way of storing values
    {
        GachaMachine gachaRoll1 = new GachaMachine();
        boolean gachaDone = false;
        while (!gachaDone)
        {
            System.out.println("Resources: "+ objPlayer1.getResourceInventory().getAmount());
            System.out.print("\nChoose from the Roll Center: ");
            String gachaSelect = new Scanner(System.in).next();
            switch (gachaSelect)
            {
                case "1": //SinglecharRoll
                {
                    if (objPlayer1.enoughResource(300))
                    {
                        objPlayer1.setUpdatedResource(300);
                        objPlayer1.receiveCharacter(gachaRoll1.singleChar());
                        //one character
                    }
                    break;

                }
                case "2": //TencharRoll
                {
                    if (objPlayer1.enoughResource(2700))
                    {
                        objPlayer1.setUpdatedResource(2700);
                        objPlayer1.receiveManyChar(gachaRoll1.tenCharacter());
                    }
                    break;

                }
                case "3": //singleWeapon
                {
                    if (objPlayer1.enoughResource(300))
                    {
                        objPlayer1.setUpdatedResource(300);
                        objPlayer1.receiveWeapon (gachaRoll1.singleWeapon());
                    }
                    break;
                }
                case "4": //tenWeapon
                {
                    if (objPlayer1.enoughResource(2700))
                    {
                        objPlayer1.setUpdatedResource(2700);
                        objPlayer1.receiveManyWeapon(gachaRoll1.tenWeapon());
                    }
                    break;

                }
                case "5":
                {
                    System.out.println(">>>Returning to Main Menu");
                    gachaDone = true;
                    break;
                }

                default:
                    System.out.println("ERROR: Invalid input");
            }

        }

    }
    private void gameAdventure()
    {

        if (objPlayer1.getCharacterInventory().size()<=1)
        {//this confirms if user has enough character in inventory to initiate an adventure
            //System.out.println("");
            System.out.println("\n>>>You do not have enough Characters in your Inventory ");
        }

        else {
            System.out.println("\nCHARACTERS AVAILABLE & READY TO GO:\n");
            objPlayer1.displayCharacters();
            //System.out.println("");
            System.out.println("\nInput the Number of the First Character You Want to deploy");
            int charCoord1 = objPlayer1.equipChar(0);

            System.out.println("Input the Number of the Second Character You Want to deploy");
            int charCoord2 = objPlayer1.equipChar(charCoord1);


            System.out.println("\n"+objPlayer1.getCharacterInventory().get(charCoord1-1).getCharName()+" Has been deployed.");
            System.out.println(objPlayer1.getCharacterInventory().get(charCoord2-1).getCharName()+" Has been deployed.");

            Adventure adventure1 = new Adventure (objPlayer1.getCharacterInventory().get(charCoord1-1),objPlayer1.getCharacterInventory().get(charCoord2-1),objPlayer1.getChosenMap());

            System.out.println(">>>PLAYING IN : "+objPlayer1.getChosenMap().getName());
            objPlayer1.playerEarnResource(adventure1.goAdventure());

            /*This part of the program will deploy characters in the inventory(excluding the repeated ones and
              checks if enough characters in inventory through getters and a method from the player class)*/


            System.out.println("Resources: "+ objPlayer1.getResourceInventory().getAmount());


        }



    }

    // MERGE METHODS -----------------------------------------
    private void mergeCharacters() {
        MergeManager charMerge = new MergeManager();

        System.out.println("\n--- Character Inventory ---");
        objPlayer1.displayCharacters();
        // Player add characters to merge list
        do {
            // While mergelist does not have three characters
            switch (charMerge.numCharacters()) {
                case 0:
                    System.out.println("\nChoose a character to upgrade");
                    break;
                default:
                    System.out.println("\nChoose extra character to merge");
            }

            Character selectChar = objPlayer1.selectCharacter();
            if (!charMerge.allCharacters().contains(selectChar))
                charMerge.receiveCharacter(selectChar);
            else
                System.out.println("ERROR: Character already selected\n");
        } while (charMerge.numCharacters() < 3);

        // remove characters in inventory
        for (Character inList:
                charMerge.allCharacters()) {
            objPlayer1.removeCharacter(inList);
        }

        // manager evaluates merge success
        // return character/s to player
        if (charMerge.sameCharacters()) {
            if (charMerge.returnAllWeapons().size() > 0)
                objPlayer1.receiveManyWeapon(charMerge.returnAllWeapons());

            objPlayer1.receiveCharacter(charMerge.charRarityUp());
            System.out.println("\nMerge success!");
        }
        else {
            objPlayer1.receiveManyChar(charMerge.allCharacters());
            System.out.println("\nMerge fail...");
        }

    }

    private void mergeWeapons() {
        MergeManager weaponMerge = new MergeManager();

        System.out.println("\n--- Weapon Inventory ---");
        objPlayer1.displayWeapons();
        // Player add game_elements.weapons to merge list
        do {
            switch (weaponMerge.numWeapons()) {
                case 0:
                    System.out.println("\nChoose a weapon to upgrade");
                    break;
                case 1:
                case 2:
                    System.out.println("\nChoose extra weapon to merge");
                    break;
                default:
                    System.out.println("\n\nWeapon cannot be merged anymore");
            }

            Weapon selectWeapon = objPlayer1.selectWeapon();
            if (!weaponMerge.allWeapons().contains(selectWeapon))
                weaponMerge.receiveWeapon(selectWeapon);
            else
                System.out.println("ERROR: Weapon already selected\n");

        } while (weaponMerge.numWeapons() < 3);

        // Remove game_elements.weapons in merge list from inventory
        for (Weapon inList:
                weaponMerge.allWeapons()) {
            objPlayer1.removeWeapon(inList);
        }

        // Merge manager evaluates merge success
        // Return weapon/s to player
        if (weaponMerge.sameWeapons()) {
            objPlayer1.receiveWeapon(weaponMerge.weaponRarityUp());
            System.out.println("\nMerge success!");
        }
        else {
            objPlayer1.receiveManyWeapon(weaponMerge.allWeapons());
            System.out.println("\nMerge fail...");
        }


    }

    // LEVEL UP METHODS ------------------------
    private void levelUpCharacter() {
        // Add window menu and scanner
        Resource bank = objPlayer1.getResourceInventory();

        System.out.println("\n--- Character Inventory ---");
        objPlayer1.displayCharacters();
        System.out.println("\nChoose a character to level up");
        // Player chooses character to level up
        LevellingManager charLevel = new LevellingManager(objPlayer1.selectCharacter());

        // Player inputs amount to level up
        // Character is levelled up
        if (charLevel.charCanLevelUp()) {
            charLevel.charLevelUp(bank);
        }
        else
            System.out.println("\nCannot level up. Character is at max level.");
        // If character is at max level, nothing happens.


    }

    private void levelUpWeapon() {
        Resource bank = objPlayer1.getResourceInventory();

        System.out.println("\n--- Weapon Inventory ---");
        objPlayer1.displayWeapons();
        System.out.println("\nChoose a weapon to level up");
        LevellingManager weaponLevel = new LevellingManager(objPlayer1.selectWeapon());
        if (weaponLevel.weaponCanLevelUp())
            weaponLevel.weaponLevelUp(bank);
        else
            System.out.println("\nCannot level up. Character is at max level.");


    }
} //<---End bracket for the game class
