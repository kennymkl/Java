package game_elements.pools;

import java.util.ArrayList;

public class CharSetter {
    private String element;
    private int rarity;
    private String weaponTag;

    public CharSetter() {
    }
    public CharSetter(String name) {

        switch (name) {
            case "Jekyll": {
                this.rarity = 1;
                this.element = "Joker";
                this.weaponTag = "Bladed";
                break;
            }
            case "Earl Robert": {
                this.rarity = 1;
                this.element = "Trigger";
                this.weaponTag = "Ranged";
                break;
            }
            case "Count d'Artagnan": {
                this.rarity = 1;
                this.element = "Metal";
                this.weaponTag = "Magical";
                break;
            }
            case "Stede": {
                this.rarity = 1;
                this.element = "Cyclone";
                this.element = "Bladed";
                break;
            }
            case "Kaguya": {
                this.rarity = 1;
                this.element = "Luna";
                this.weaponTag = "Ranged";
                break;
            }
            case "Van Helmont": {
                this.rarity = 1;
                this.element = "Heat";
                this.weaponTag = "Magical";
                break;
            }
            case "Gray": {
                this.rarity = 2;
                this.element = "Joker";
                this.weaponTag = "Magical";
                break;
            }
            case "Bonney": {
                this.rarity = 2;
                this.element = "Trigger";
                this.weaponTag = "Bladed";
                break;
            }
            case "Sir William Marshal": {
                this.rarity = 2;
                this.element = "Metal";
                this.weaponTag = "Ranged";
                break;
            }
            case "Teach": {
                this.rarity = 2;
                this.element = "Cyclone";
                this.weaponTag = "Magical";
                break;
            }
            case "Jeanne": {
                this.rarity = 2;
                this.element = "Luna";
                this.weaponTag = "Bladed";
                break;
            }
            case "Paracelsus": {
                this.rarity = 2;
                this.element = "Heat";
                this.weaponTag = "Ranged";
                break;
            }
            case "Faust": {
                this.rarity = 3;
                this.element = "Joker";
                this.weaponTag = "Ranged";
                break;
            }
            case "Clyde": {
                this.rarity = 3;
                this.element = "Trigger";
                this.element = "Magical";
                break;
            }
            case "Masamune": {
                this.rarity = 3;
                this.element = "Metal";
                this.weaponTag = "Bladed";
                break;
            }
            case "Avery": {
                this.rarity = 3;
                this.element = "Cyclone";
                this.weaponTag = "Ranged";
                break;
            }
            case "Arthur": {
                this.rarity = 3;
                this.element = "Luna";
                this.weaponTag = "Magical";
                break;
            }
            case "Hermes": {
                this.rarity = 3;
                this.element = "Heat";
                this.weaponTag = "Bladed";
                break;
            }
        }
    }


    public String returnElement() {
            return this.element;
    }
    public int returnRarity () {
            return this.rarity;
    }

    public String returnTag () {
        return this.weaponTag;
    }
}

