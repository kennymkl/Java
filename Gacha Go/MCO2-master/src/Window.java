public class Window{

  public void displayBegin()
  {
    System.out.println("W E L C O M E  TO  G A C H A   G O");
    System.out.println("Enter Your Name, Adventure Master ");
  }

//--GENERAL MENU-------------------------------------------------
//displays the menu screen of the Game
  public void displayMenu ()
  {
    System.out.println("");
    System.out.println("");
    System.out.println (" [[G  A  C  H  A          G  O !!!]]");
    System.out.println("----------------------------------------");
    System.out.println ("| ENTER [I] for Inventory & Map Setting |");
    System.out.println("| ENTER [R] to Roll in Gacha Machine    |");
    System.out.println ("| ENTER [P] to Play Adventure           |");
    System.out.println("| ENTER [X] to Restart Game             |");
    System.out.println("-----------------------------------------");

  }
  
//--INVENTORY & MAP SETTINGS------------------------------------------
//displays inventory and map setting screen
  public void displayInvMapSettings ()
  {

    System.out.println("");
    System.out.println ("     {...}Inventory & Map Setting{...}   ");
    System.out.println("-------------------------------------------");
    System.out.println("ENTER [1] -> View Current Inventory");
    System.out.println("ENTER [2] -> Equip a Weapon");
    System.out.println("ENTER [3] -> Select Adventure Map");
    System.out.println("ENTER [4] -> Merge Characters or Weapons");
    System.out.println("ENTER [5] -> Level up a Character or Weapon");
    System.out.println("ENTER [6] -> Cancel and Return to Main Menu");
    System.out.println("-------------------------------------------");
  }
  //display the screen for equip Options
  public void displayEquipOptions(){
    System.out.println("+++  Equip Center  +++");
    System.out.println
    ("-------------------------------------------");
    System.out.println("[1] Equip a weapon");
    System.out.println("[2] Unequip a weapon");
    System.out.println("[3] Cancel and Return to Inventory and Map Settings");
    System.out.println("-------------------------------------------");
  }
  //display screen for merge Options
  public void displayMergeOptions(){
    System.out.println("+++  Merge Center  +++");
    System.out.println
    ("-------------------------------------------");
    System.out.println("[1] Merge and Upgrade Characters");
    System.out.println("[2] Merge and Upgrade Weapons");
    System.out.println("[3] Cancel and Return to Inventory and Map Settings");
    System.out.println("-------------------------------------------");
  }
  //display screen for level Options
  public void displayLevelOptions(){
    System.out.println("+++  Levelling Center  +++");
    System.out.println
    ("-------------------------------------------");
    System.out.println("[1] Level up Characters");
    System.out.println("[2] Level up Weapons");
    System.out.println("[3] Cancel and Return to Inventory and Map Settings");
    System.out.println
    ("-------------------------------------------");
  }
  //display screen for map Options
  public void displayMapOptions ()
  {
    System.out.println("");
    System.out.println("          {...}Map Options{...}");
    System.out.println("-------------------------------------------");
    System.out.println("ENTER [1] -> Underground Caverns");
    System.out.println("Base Reward: 53");
    System.out.println("ENTER [2] -> Forest of Enchantments");
    System.out.println("Base Reward: 77");
    System.out.println("ENTER [3] -> Sea of Hope");
    System.out.println("Base Reward: 85");
    System.out.println("ENTER [4] -> Tower of Ether");
    System.out.println("Base Reward: 91");
    System.out.println("ENTER [5] -> Celestial Plane");
    System.out.println("Base Reward: 100");
    System.out.println("-------------------------------------------");

  }
  
//----ADVENTURE DISPLAYS---------------------------------------------
  public void displayAdventure()
  {
    System.out.println("");
    System.out.println("    {o}{=}{X} PLAY ADVENTURE {X}{=}{o}    ");
    System.out.println("");
    System.out.println(" ");
    
    System.out.println("[1]-> Proceed and Deploy to Adventure");
    System.out.println("[2]-> Cancel and Return to Menu");
    System.out.println("-------------------------------------------");


  } //adventure displays for the screen

  //---GACHA ROLL DISPLAYS------------------------------------------
  public void displayRoll()
  { 
    System.out.println("");
    System.out.println("");
    System.out.println(" [::]ROLL CENTER[::] ");
    System.out.println("------------------------");
    System.out.println("Single Character Spin");
    System.out.println("cost: 300 Resources");
    System.out.println("------------------------");
    System.out.println("Ten Character Spin");
    System.out.println("cost:̶3̶0̶0̶0 2700 Resources");
    System.out.println("------------------------");
    System.out.println("Single Weapon Spin");
    System.out.println("cost: 300 Resources");
    System.out.println("------------------------");
    System.out.println("Ten Weapon Spin");
    System.out.println("cost:̶3̶0̶0̶0 2700 Resources");
    System.out.println("------------------------");
    System.out.println("");

    System.out.println("ENTER [1] -> Single Character Roll");
    System.out.println("ENTER [2] -> Ten Character Roll");
    System.out.println("ENTER [3] -> Single Weapon Roll");
    System.out.println("ENTER [4] -> Ten Weapon Roll");
    System.out.println("ENTER [5] -> Return to Menu");
//displays screen for the gacha segment of the Game

    //SINGLE CHARACTER ROLL:

    //TEN CHARACTER ROLL:

    //SINGLE WEAPON ROLL:

    //TEN WEAPON ROLL:

  }
  
}