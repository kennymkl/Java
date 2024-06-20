package game_elements;

public class Enemy{
    private String name;
    private int count;
    private int power;


    public Enemy(String name, int count) {
        this.name = name;
        this.count = count;

        //Set Base Power
        switch (this.name) {
            case "Slime":
                this.power = 73;
                break;
            case "Orc":
                this.power = 84;
                break;
            case "Familiar":
                this.power = 144;
                break;
            case "Faerie":
                this.power = 175;
                break;
            case "Elf":
                this.power = 224;
                break;
            case "Sorcerer":
                this.power = 313;
                break;
            case "Hydra":
                this.power = 360;
                break;
            case "Basilisk":
                this.power = 499;
                break;
            case "Harpy":
                this.power = 639;
                break;
            case "Loki":
                this.power = 740;
                break;
        }
    }
    
    /* Total power used in calculating enemy superiority in Map class
    */
    public int totalPower(){
        return count*power;
  }
}