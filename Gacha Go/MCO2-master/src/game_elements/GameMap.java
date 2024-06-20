package game_elements;

import java.util.ArrayList;

public class GameMap {
  private String name;
  private int resourceBaseAmount;
  private ArrayList<Enemy> enemyList = new ArrayList<>();


  /*
  >>> MAP INDEX GUIDE
  [0] Underground Caverns
  [1] Forest of Enchantments
  [2] Sea of Hope
  [3] Tower of Ether
  [4] Celestial Plane
  */
    public String getName() {
        return this.name;
    }
    public int getBase(){
        return this.resourceBaseAmount;
        }
    public GameMap(int mapIndex) {
        switch (mapIndex) {
            case 0:
            default: 
                this.name = "Underground Caverns";
                this.resourceBaseAmount = 53;
                break;
            case 1:
                this.name = "Forest of Enchantments";
                this.resourceBaseAmount = 77;
                break;
            case 2: 
                this.name = "Sea of Hope";
                this.resourceBaseAmount = 85;
                break;
            case 3: 
                this.name = "Tower of Ether";
                this.resourceBaseAmount = 91;
                break;
            case 4: 
                this.name = "Celestial Plane";
                this.resourceBaseAmount = 100;
                break; 
        }
    }

  // Set enemy list depending on the map
    public void setEnemyList(int mapIndex) {
        switch (mapIndex) {
            case 0: // Underground Caverns
                this.enemyList.add(new Enemy("Elf", 1));
                this.enemyList.add(new Enemy("Slime", 6));
                break;
            case 1: // Forest of Enchantments
                this.enemyList.add(new Enemy("Slime", 5));
                this.enemyList.add(new Enemy("Orc", 5));
                this.enemyList.add(new Enemy("Familiar", 3));
                this.enemyList.add(new Enemy("Faerie", 3));
                this.enemyList.add(new Enemy("Elf", 2));
                this.enemyList.add(new Enemy("Sorcerer", 1));
                break;
            case 2: // Sea of Hope
                this.enemyList.add(new Enemy("Slime", 75));
                this.enemyList.add(new Enemy("Sorcerer", 20));
                this.enemyList.add(new Enemy("Hydra", 5));
                break;
            case 3: // Tower of Ether
                this.enemyList.add(new Enemy("Basilisk", 20));
                this.enemyList.add(new Enemy("Harpy", 7));
                this.enemyList.add(new Enemy("Loki", 5));
                break;
            case 4: // Celestial Plane
                this.enemyList.add(new Enemy("Faerie", 50));
                this.enemyList.add(new Enemy("Hydra", 20));
                this.enemyList.add(new Enemy("Loki", 10));
                break;
        }
    }

    //Calculates the total enemySuperiority of the enemies in a specific map
    public int enemySuperiority() {

        int superiority = 0;

        for (int i = 0; i < this.enemyList.size(); i++) {
            superiority += this.enemyList.get(i).totalPower();
            System.out.println(superiority);
        }
        return superiority;
    }

}