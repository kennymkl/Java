package game_elements.pools;

public class WeaponSetter {
    private int power;
    private int rarity;
    private String type;

    public WeaponSetter() {
    }

    public WeaponSetter(String name) {
        switch (name) {
            case "Knife": {
                this.power = 130;
                this.rarity = 1;
                this.type = "Bladed";
                break;
            }
            case "Rapier": {
                this.power = 140;
                this.rarity = 1;
                this.type = "Bladed";
                break;
            }
            case "Revolver": {
                this.power = 150;
                this.rarity = 1;
                this.type = "Ranged";
                break;
            }
            case "Mermaid Tears": {
                this.power = 160;
                this.rarity = 1;
                this.type = "Magical";
                break;
            }
            case "Clarent": {
                this.power = 170;
                this.rarity = 1;
                this.type = "Bladed";
                break;
            }
            case "English Longbow": {
                this.power = 180;
                this.rarity = 1;
                this.type = "Ranged";
                break;
            }
            case "Circe Staff": {
                this.power = 150;
                this.rarity = 2;
                this.type = "Magical";
                break;
            }
            case "Vorpal Sword": {
                this.power = 160;
                this.rarity = 2;
                this.type = "Magical";
                break;
            }
            case "Merlin's Staff": {
                this.power = 170;
                this.rarity = 2;
                this.type = "Magical";
                break;
            }
            case "Five-cross Sword": {
                this.power = 180;
                this.rarity = 2;
                this.type = "Bladed";
                break;
            }
            case "Bashoshen": {
                this.power = 190;
                this.rarity = 2;
                this.type = "Ranged";
                break;
            }
            case "Golden Cudgel": {
                this.power = 200;
                this.rarity = 2;
                this.type = "Golden";
                break;
            }
            case "Philosopher's Stone": {
                this.power = 180;
                this.rarity = 3;
                this.type = "Magical";
                break;
            }
            case "Magic Bullets": {
                this.power = 190;
                this.rarity = 3;
                this.type = "Ranged";
                break;
            }
            case "Fragarach": {
                this.power = 200;
                this.rarity = 3;
                this.type = "Bladed";
                break;
            }
            case "Honjo Masamune": {
                this.power = 210;
                this.rarity = 3;
                this.type = "Bladed";
                break;
            }
            case "Excalibur": {
                this.power = 220;
                this.rarity = 3;
                this.type = "Bladed";
                break;
            }
            case "Scythe of Father Time": {
                this.power = 230;
                this.rarity = 3;
                this.type = "Golden";
                break;
            }
        }
    }

    public int returnPower() {
        return this.power;
    }

    public int returnRarity() {
        return this.rarity;
    }

    public String returnType() { return this.type; }

}
