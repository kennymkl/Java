package managers;/*
This is the Adventure Class. Its responsibilities are what concern the player when engaging with the deploy adventure mode of the Game

*/

import game_elements.gacha_characters.Character;
import game_elements.GameMap;

public class Adventure {
  private Character char1;
  private Character char2;
  private GameMap gameMap1;

//the Adventure class take in the Character variables and the Map when creating the adventure

  public Adventure(Character char1, Character char2, GameMap gameMap1){
    this.char1 = char1; 
    this.char2 = char2;
    this.gameMap1 = gameMap1;


  }
//*-Main Adventure Method---------------------------------------

  public int goAdventure()
  //will return resource amount reward because after adventure there will be a reward
  {
    int finalReward;
    /*
    Flow of the goAdventure Method and Contribution to the Game class:

    1. element combination
    2. isSuccessful
    3. setLevel
    4. Return total reward*/
    
    this.elementComb();
    int success = this.isSuccessful();
    this.adventureLevel(success);
    finalReward = totalReward();
    System.out.println("\nCongratulations, Adventure Master."); 
    System.out.println("You have earned "+ finalReward +" total resources");
    return finalReward;

  }
//------------------------------------------------------------

  private double elementComb() //This method will return the multiplier that will be used for calculating the totalReward
  {
    int element1 = elementNum(this.char1.getElement());
    int element2 = elementNum(this.char2.getElement());
    int elementSum = element1+element2;
    double elemRate;

    if (element1==element2)
      elemRate = 0.10;
    else
    {
      switch (elementSum)
      {
        case 3:
        case 4:
          elemRate = 0.25;
          break;
        case 5:
          {
            if (element1 == 4||element2 == 4)
              elemRate = 0.75;
            else
              elemRate = 0;
          }
          break;
        case 6:
          {
            if (element1==5||element2==5)
              elemRate = 0.50;
            else
              elemRate = 0;
          }
          break;
        case 7:
          {
            if (element1==2||element2==2)
              elemRate = 0.75;
            else if (element1==6||element2==6)
              elemRate = 0.50;
            else
              elemRate = 0.25;
          }
          break;
        case 8:
        {
          if (element1==5||element2==5)
            elemRate = 0.25;
          else
            elemRate = 0;
        }
        break;
        case 9:
        {
          if (element1==6||element2==6)
            elemRate = 0.75;
          else
            elemRate = -0.25;
        }
        break;
        default:
          elemRate = -0.25;
          break;
      }
    }
    return elemRate;
  }
  
  public int elementNum(String elementName) //this method will assign int values from 1 to 6 for the appropriate element type
  {
     int elemNum;
    switch (elementName)
    {
      case "Joker":
        elemNum = 1;
        break;
      case "Trigger":
        elemNum = 2;
        break;
      case "Metal":
        elemNum = 3;
        break;
      case "Cyclone":
        elemNum = 4;
        break;
      case "Luna":
        elemNum = 5;
        break;
      default:
        elemNum = 6;
        break;
      
    }
    return elemNum;

  }
  private int totalReward() //this will calculate the totalreward for the adventure
  {
     // default
    double powerChar1 = 0;
    double powerChar2 = 0;

    if (this.char1.hasWeapon()) 
        powerChar1 = this.char1.getWeapon().finalPower();
    if (this.char2.hasWeapon())
        powerChar2 = this.char2.getWeapon().finalPower();
    
    // character influence
    double influenceChar1 = this.char1.influence();
    double influenceChar2 = this.char2.influence();

    //element combination multiplier 
    double combMultiply = this.elementComb();

    int mapBase = this.gameMap1.getBase();
    int calcPower = (int)(powerChar1+powerChar2)/24;
    int calcInfluence = (int) (((influenceChar1+influenceChar2)/36)*combMultiply);

    return mapBase +calcPower*calcInfluence;
  }


 //Determines if the adventure was successful:
  //0 = Not isSuccessful
  //1 = Normal isSuccessful
  //2 = Excellent isSuccessful

  private int isSuccessful () //this will calculate and tell if the adventure was successful or Not
  {
     // default
    double powerChar1 = 0;
    double powerChar2 = 0;

    if (this.char1.hasWeapon())
        powerChar1 = this.char1.getWeapon().finalPower();
    if (this.char2.hasWeapon())
        powerChar2 = this.char2.getWeapon().finalPower();
        
    double influenceChar1 = this.char1.influence();
    double influenceChar2 = this.char2.influence();

    double enemySuper = gameMap1.enemySuperiority();
    System.out.println(gameMap1.enemySuperiority());
    double pairSuper = ((powerChar1+powerChar2)*((influenceChar1+influenceChar2)/10));

    if (pairSuper<enemySuper)
    {
      System.out.println("");
      System.out.println("");
      System.out.println("");
      System.out.println(">>>Good Effort. Your heroes have failed.");
      return 0;
    }
    else
      if ((pairSuper/enemySuper)>=1.5)
      {
      System.out.println("");
      System.out.println("");
      System.out.println("");
      System.out.println(">>>Excellently Accomplished!.");
      System.out.println(">>>Your heroes have prevailed.");
        return 2;
      }
        
      else
      {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(">>>Your heroes have prevailed.");
        return 1;

      }
  }
//function that sets the level up for characters involved
  private void adventureLevel (int successResult) {
    this.char1.levelUp(successResult);
    this.char2.levelUp(successResult);
  }
}