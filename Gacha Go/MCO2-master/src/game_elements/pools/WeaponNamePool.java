package game_elements.pools;

import java.util.ArrayList;

public class WeaponNamePool {
    private ArrayList<String> weaponNames= new ArrayList<>();
    private ArrayList<String> bladedNames = new ArrayList<>();
    private ArrayList<String> rangedNames = new ArrayList<>();
    private ArrayList<String> magicalNames = new ArrayList<>();
    private ArrayList<String> goldenNames = new ArrayList<>();

    public WeaponNamePool() {
        // +++ Weapons +++
        //Initialize name, rarity, level, power

        // Rarity 1
        weaponNames.add("Knife");
        weaponNames.add("Rapier");
        weaponNames.add("Revolver");
        weaponNames.add("Mermaid Tears");
        weaponNames.add("Clarent");
        weaponNames.add("English Longbow");

        // Rarity 2
        weaponNames.add("Circe Staff");
        weaponNames.add("Vorpal Sword");
        weaponNames.add("Merlin's Staff");
        weaponNames.add("Five-cross Sword");
        weaponNames.add("Bashosen");
        weaponNames.add("Golden Cudgel");

        // Rarity 3
        weaponNames.add("Philosopher's Stone");
        weaponNames.add("Magic Bullets");
        weaponNames.add("Fragarach");
        weaponNames.add("Honjo Masamune");
        weaponNames.add("Excalibur");
        weaponNames.add("Scythe of Father Time");

        //Bladed Weapons
        bladedNames.add("Knife");
        bladedNames.add("Rapier");
        bladedNames.add("Clarent");
        bladedNames.add("Five-cross Sword");
        bladedNames.add("Fragarach");
        bladedNames.add("Honjo Masamune");
        bladedNames.add("Excalibur");

        //Ranged Weapons
        rangedNames.add("Revolver");
        rangedNames.add("English Longbow");
        rangedNames.add("Bashosen");
        rangedNames.add("Magic Bullets");

        //Magical Weapons
        magicalNames.add("Mermaid Tears");
        magicalNames.add("Circe Staff");
        magicalNames.add("Vorpal Sword");
        magicalNames.add("Merlin's Staff");
        magicalNames.add("Philosopher's Stone");

        //Golden Names
        goldenNames.add("Golden Cudgel");
        goldenNames.add("Scythe of Father Time");
    }

    public int size() {return weaponNames.size();}

    public String returnName(int index) {
        return weaponNames.get(index);
    }

    public String returnType(String name) {
        if (bladedNames.contains(name))
            return "Bladed";
        else if (rangedNames.contains(name))
            return "Ranged";
        else if (magicalNames.contains(name))
            return "Magical";
        else
            return "Golden";
    }

    public ArrayList<String> getNames() {
        return weaponNames;
    }
}
