package game_elements.pools;

import java.util.ArrayList;

public class CharNamePool {
    private ArrayList<String> charNames = new ArrayList<>();

    public CharNamePool() {
        // +++ Characters +++
        //Initialize name, rarity, level, element

        // Rarity 1 - Bladed
        charNames.add("Jekyll");
        charNames.add("Stede");
        // Rarity 1 - Ranged
        charNames.add("Earl Robert");
        charNames.add("Kaguya");
        // Rarity 1 - Magical
        charNames.add("Count d'Artagnan");
        charNames.add("Van Helmont");

        // Rarity 2 - Bladed
        charNames.add("Bonney");
        charNames.add("Jeanne");
        // Rarity 2 - Ranged
        charNames.add("Sir William Marshal");
        charNames.add("Paracelsus");
        // Rarity 3 - Magical
        charNames.add("Gray");
        charNames.add("Teach");

        // Rarity 3 - Bladed
        charNames.add("Masamune");
        charNames.add("Hermes");
        // Rarity 3 - Ranged
        charNames.add("Faust");
        charNames.add("Avery");
        // Rarity 3 - Magical
        charNames.add("Clyde");
        charNames.add("Arthur");
    }

    public int size(){
        return charNames.size();
    }

    public String returnName(int index) {
        return charNames.get(index);
    }

    public ArrayList<String> getNames() {
        return charNames;
    }
}
