package game_elements.weapons;

import game_elements.pools.WeaponSetter;

public class Weapon {
    private String name;
    protected int power;
    protected int rarity;
    protected int level;
    private String type;
    protected boolean equipped;

// Constructor
    public Weapon() {
    }

    // Getters
    public String getName(){
        return this.name;
    }
    public int getRarity(){
        return this.rarity;
    }
    public int getLevel (){
        return this.level;
    }
    public int getPower() {return this.power;}
    public boolean isEquipped() {
        return this.equipped;
    }

    // Setters
    public void initializeWeapon(String name) {
        this.name = name;
        this.level = 1;

        WeaponSetter wSet = new WeaponSetter(name);
        this.setPower(wSet.returnPower());
        this.setRarity(wSet.returnRarity());
        this.setType(wSet.returnType());
    }
    private void setPower(int power) { this.power = power; }
    public void setRarity(int rarity) { this.rarity = rarity; }
    private void setType (String type) { this.type = type; }
    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }
    // Returns multiplier for weapon's current rarity
    // Helper method for finalPower()
    private double multiplier() {
        switch(this.rarity) {
            case 1: 
                return 0.7; 
            case 2:
                return 0.8; 
            case 3: 
                return 0.9; 
            case 4:
                return 1.0; 
            default: //case 5
                return 1.2;
        }
    }

    /* Function that returns weapon's final power  
       Used to calculate characterSuperiority in Adventure
    */
    public double finalPower() {
        return power * this.multiplier() + level;
    }

    /* Function that increases this game_elements.weapons's level by a specified amount
       Parameter @levelAdded is the number to increase to this weapon's level
       @levelAdded determined by LevellingManager or Adventure
    */
    public void levelUp (int levelAdd) {
        if (this.level < 50)
            this.level += levelAdd;
    }

    /* Function that increases this weapon's rarity by one
       Rarity is normally increased just by one, and only after a successful merge
    */
    public void rarityUp(){
        this.rarity++;
    }


}