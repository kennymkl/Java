import game_elements.gacha_characters.Character;
import game_elements.GameMap;
import game_elements.Resource;
import game_elements.weapons.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

  private Resource resourceInventory;
  private ArrayList <Character> characterInventory;
  private ArrayList <Weapon> weaponInventory;
  private GameMap chosenMap;

  //Constructor-------------------------------------------------------


  public Player ()
  {
    this.characterInventory = new ArrayList <Character> ();
    this.weaponInventory = new ArrayList <Weapon> ();
    this.chosenMap = new GameMap(0);
    this.chosenMap.setEnemyList(0);
    
  }

  //Getters----------------------------------------------------------

  public Resource getResourceInventory (){
    return this.resourceInventory;
  }
  public ArrayList <Character> getCharacterInventory (){
    return this.characterInventory;
  }
  public ArrayList <Weapon> getWeaponInventory (){
    return this.weaponInventory;
  }

  public GameMap getChosenMap () {
    return this.chosenMap;
  }
  
  //Setters--------------------------------------------------------
  
  public void setResourceInventory (Resource newResource){
    this.resourceInventory = newResource;
  }

//Receivers--------------------------------------------------------

/*
Receive methods which will be used by the player when it comes to merging inventory and gacha pulling
*/

public void receiveCharacter(Character charReward)
{
  this.characterInventory.add(charReward);
  System.out.println("You have Received: "+charReward.getCharName());

}

public void receiveWeapon(Weapon weaponReward)
{
  this.weaponInventory.add(weaponReward);
  System.out.println("You have Received: "+weaponReward.getName());
}

public void receiveManyChar(ArrayList<Character> receiveChars) {
    this.characterInventory.addAll(receiveChars);
        
    System.out.println("You Received Collection:");
    for (Character receiveChar : receiveChars) {
        String name = receiveChar.getCharName();
        System.out.println(name);
    }
}

public void receiveManyWeapon(ArrayList<Weapon> receiveWeapons) {
        this.weaponInventory.addAll(receiveWeapons);      
        System.out.println("You Received Collection:");
    for (Weapon receiveWeapon : receiveWeapons) {
        String name = receiveWeapon.getName();
        System.out.println(name);
    }
  }

//----Player Resource Transactions------------------------------------

public void playerEarnResource (int resourceReward)
{
  this.resourceInventory.earn(resourceReward);
}

public void setUpdatedResource(int cost)
{
  this.resourceInventory.setAmount(this.resourceInventory.consume(cost));
//setAmount(this.resourceInventory.
}
public boolean enoughResource (int cost)
{
  if (this.resourceInventory.getAmount()>=cost)
    return true;
  else
    System.out.println("");
    System.out.println(">>>You do not have enough Resources.");
    return false;
}


//----display methods(adventure & inventory setting)--------------

public void displayCharacters() {
  System.out.println("\n\n     +++  Character Inventory  +++");
  System.out.println("-------------------------------------------");
  for (int i = 0; i < this.characterInventory.size(); i++) {
    String characterName = this.characterInventory.get(i).getCharName();
    String level = String.valueOf(this.characterInventory.get(i).getLevel());
    String rarity = String.valueOf(this.characterInventory.get(i).getRarity());
    
    System.out.println(i+1+": LVL"+" "+level+" "+characterName+" "+rarity);
  }
}

public void displayWeapons() {
  System.out.println("\n      +++  Weapon Inventory  +++");
  System.out.println("-------------------------------------------");
  for (int i = 0; i < this.weaponInventory.size(); i++){
    String weaponName = 
    this.weaponInventory.get(i).getName();
    String level = String.valueOf(this.weaponInventory.get(i).getLevel());
    String rarity = String.valueOf(this.weaponInventory.get(i).getRarity());
    System.out.println(i+1+": LVL"+" "+level+" "+weaponName+" "+rarity);
  } 
}

public void viewSpecificCharacter(Character character) {
    System.out.println("\nNAME: "+character.getCharName());
    System.out.println("LEVEL: "+character.getLevel());
    System.out.println("RARITY: "+character.getRarity());
    System.out.println("ELEMENT: "+character.getElement());
    System.out.println("Can hold "+character.getWeaponTag()+" weapons");
    if (character.hasWeapon())
        System.out.println("\nCURRENT WEAPON: "+character.getWeapon().getName());
}
//Selection methods----------------------------------------------------------

    // parameters @limit mean the max number accepted (inclusive)
    private int getIntInput(int upperLimit) {
        Scanner select = new Scanner (System.in);
        int number = select.nextInt();

        while (number <= 0 || number > upperLimit) {
            System.out.println("ERROR: Invalid input");
            System.out.print(">>> Input: ");
            number = select.nextInt();
        }
        return number;
    }

    // Gets user input which is the index of the character in inventory
    // Used to get a character for merging, levelling and selecting a character that will equip and unequip game_elements.weapons in the game class
    // Note: Listing in display is from 1 up to number of objects
    public Character selectCharacter()
    {
        int select = this.getIntInput(this.characterInventory.size());
        System.out.println(">>> You chose "+this.characterInventory.get(select-1).getCharName());
        return this.characterInventory.get(select-1);
    }
    
    // Method to select characters specifically for adventure
    public int equipChar(int prohibitIndex)
    {
      if (prohibitIndex == 0)
      {
        int select = this.getIntInput(this.characterInventory.size());
        System.out.println(">>> You have equipped "+this.characterInventory.get(select-1).getCharName());
        
        return select;  
      }
      else
      {
        int select = this.getIntInput(this.characterInventory.size());
        while (select == prohibitIndex)
        {
          System.out.println("ERROR: You cannot deploy this Character Anymore.");
          select = this.getIntInput(this.characterInventory.size());
        }
        System.out.println(">>> You have equipped "+this.characterInventory.get(select-1).getCharName());
        return select;

      }
    }

    // Gets user input which is the index of the weapon in inventory
    // Used to get a weapon for merging, levelling and selecting a character that will equip and unequip game_elements.weapons in the game class
    public Weapon selectWeapon() {
        int select = this.getIntInput(this.weaponInventory.size());
        System.out.println(">>> You chose "+this.weaponInventory.get(select-1).getName());
        return this.weaponInventory.get(select-1);
    }

    // Responsible for map selection of character
    // Also calls setEnemyList()
    public void selectMap () 
        {
        int select = this.getIntInput(5); //5
        this.chosenMap = new GameMap (select-1);
        this.chosenMap.setEnemyList(select-1);
        System.out.println(">>> You chose "+this.chosenMap.getName());
      }
    

//---REMOVE METHODS----------------------------------------------

    public void removeCharacter(Character target) {
        this.characterInventory.remove(target);
    }
    public void removeWeapon(Weapon target) {
        this.weaponInventory.remove(target);
    }
}

