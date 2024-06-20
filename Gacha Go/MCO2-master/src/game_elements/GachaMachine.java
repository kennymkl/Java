package game_elements;

import game_elements.gacha_characters.Character;
import game_elements.pools.CharNamePool;
import game_elements.pools.CharSetter;
import game_elements.pools.WeaponNamePool;
import game_elements.pools.WeaponSetter;
import game_elements.weapons.*;

import java.util.ArrayList;
import java.util.Random;


public class GachaMachine {
    private CharNamePool cPool = new CharNamePool();
    private WeaponNamePool wPool = new WeaponNamePool();
    private ArrayList <Character> gachaChar;
    private ArrayList <Weapon> gachaWeapon;

//GachaMachine () constructor will generate a filled list of the characters and Weapons needed in the game.

    public GachaMachine () {

    }


    public Character singleChar (){
        Random charDice = new Random (); //Since there are six of each rare type, a diceroll would be the most fitting to describe this randomizer
        int index = 0;
        double probability = Math.random(); //0 to 0.999999
        if (probability < 0.50 ) //probability would be 50 percent (0-0.999)
        {
            index = charDice.nextInt(6);//0-5 index will be chosen

            return new Character(cPool.getNames().get(index));
        }
        else if (probability < 0.85)
        {
            index = 6+charDice.nextInt(6); //6-11 index
    
            return new Character(cPool.getNames().get(index));
        }
        else
        {
            index = 12+charDice.nextInt(6); //-12-17 index
            return new Character(cPool.getNames().get(index));
        }

}
    private Weapon createWeapon(String name) {
        if (wPool.returnType(name).equals("Bladed")) {
            return new BladedWeapon(name);
        }
        else if (wPool.returnType(name).equals("Ranged")) {
            return new RangedWeapon(name);
        }
        else if (wPool.returnType(name).equals("Magical")) {
            return new MagicalWeapon(name);
        }
        else
            return new GoldenWeapon(name);
    }

    /*private Weapon goldenRepull(Weapon reward) {

        do {
            >>> If weapon reward is of golden type
            >>> Get user input yes or no if they will reroll
        } while (// Weapon is still of golden type AND User input is yes)

    }*/

    public Weapon singleWeapon () {
        Random charDice = new Random();
        String rewardName;
        int index = 0;
        double probability = Math.random(); //0 to 0.999999

        if (probability < 0.50) {
            index = charDice.nextInt(6);//0-5

        } else if (probability < 0.85) {
            index = 6 + charDice.nextInt(6); //6-11

        } else {
            index = 12 + charDice.nextInt(6); //-12-17
        }
        rewardName = wPool.returnName(index);
        return this.createWeapon(rewardName);
    }


//----Methods for the ten character pulls------------------------
//this time they will return ArrayLists which will be taken by the player and stored in the inventory. (for loop is used to pull and store ten)
    public ArrayList<Character> tenCharacter() {
        ArrayList<Character> charPulls = new ArrayList<Character>();
        for (int i = 0; i < 10; i++) {
            charPulls.add(this.singleChar());
        }
        return charPulls;
}

    public ArrayList<Weapon> tenWeapon() {
        ArrayList<Weapon> weaponPulls = new ArrayList<Weapon>();
        for (int i = 0; i < 10; i++) {
        weaponPulls.add(this.singleWeapon());
    }
        return weaponPulls;
    }
  


}


