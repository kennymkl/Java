package game_elements;

public class Resource {
    private int amount;

// CONSTRUCTOR
    public Resource (String playerName) {
        this.amount = 5400; 
    } //constructs a resource of 5400 amount => types the player name (i.e. reward for logging in the game)
  
// GETTER  
    public int getAmount () {
        return this.amount;
    }
// SETTER
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public int earn(int earnings) {
        return this.amount += earnings;
    } //returns the amount of resource after earnings
    public int consume(int cost) {
        if (this.amount >= cost)
            return this.amount -= cost; //returns the reduced amount of resources
        else {
            System.out.println("Not enough resources!");
            return this.amount; // returns original amount if cost is too high
        }
        
    }
}