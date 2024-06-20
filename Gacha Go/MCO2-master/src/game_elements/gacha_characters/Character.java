package game_elements.gacha_characters;

import game_elements.pools.CharSetter;
import game_elements.weapons.Weapon;

import java.util.ArrayList;

public class Character {
    private String name;
    private int level;
    private String element; 
    private int rarity;
    private String weaponTag;
    private ArrayList<Weapon> weapon = new ArrayList<>(1);

//---Constructor-------------------------------------------------
public Character(String name){

    this.name = name; //characterName
    this.level = 20; //starting level

    CharSetter cSet = new CharSetter(name);
    this.setRarity(cSet.returnRarity());
    this.setElement(cSet.returnElement());
    this.setWeaponTag(cSet.returnTag());
}


//---Getters&Setters---------------------------------------------

    public Weapon getWeapon() {
        return this.weapon.get(0);
    }
    public String getCharName (){
        return this.name;
    }
    public int getRarity() {
        return this.rarity;
    }
    public String getElement() {
        return this.element;
    }
    public int getLevel() {
        return this.level;
    }
    public String getWeaponTag() {return this.weaponTag; }
    public void setRarity(int rarity) {
        this.rarity = rarity;
    }
    private void setElement(String element) {
        this.element = element;
    }
    private void setWeaponTag(String tag) { this.weaponTag = tag; }
    // --Utility Methods relating to the game------------------------
    
    /* Method that verifies if a character has a weapon
       Used in (1) Unequipping - player must get back the weapon
       (2) Adventure - characterSuperiority is set to 0 if character does not have a weapon
       (3) Merge - extra characters are returned to player
    */
    public boolean hasWeapon(){
        return this.weapon.size() == 1;
    }
    /* Method that sets the weapon of this character 
       Parameter @weapon is a selected by player in player.selectCharacter()
    */
    public void equip(Weapon weapon) {
        this.weapon.add(weapon);
    }

    /* Method that removes weapon from character
       Return value @holder to be received by player.receiveWeapon()
    */
    public Weapon unequipWeapon() {
        Weapon holder = this.getWeapon();
        this.weapon.remove(0);
        return holder;
    }

    /* Calculates character influence 
    */
    public double influence() {
        return level*(1+((double)rarity-1)/5);
    } 


    /* Method that increases this character's rarity by one
       Rarity is normally increased just by one, and only after a successful merge
    */
    public void rarityUp(){
        this.rarity++;
    }

    /* Method that increases this character's level by a specified amount
       Parameter @levelAdded is the number to increase to this character's level
       @levelAdded determined by LevellingManager or Adventure
    */
    public void levelUp (int levelAdd) {
        if (this.level<100)
            this.level += levelAdd; 
    }


}