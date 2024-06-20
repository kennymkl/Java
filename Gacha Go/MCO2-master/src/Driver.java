/*
MCO1B Java Implementation Project
Programmed by Daphne Ong and Kenn Villarama
Section: S16

This program is an object oriented approach to a text-based gacha game. It will loosely follow the MVC design pattern.

List of Java Classes Used for this Program:

1. Adventure -> A class for the deploying adventure segment
2. Character -> Responsible for defining characters and their behaviors in the game
3. Enemy -> Responsible for defining enemies in the game
4. GachaMachine -> Has properties of reference lists that will randomize what to pull based on rarity and type of pull
5. Game -> Overseer of managing capabilities and game flow
6. Levelling Manager -> Defines the levelling of characters or weapon and its behaviors
7. Map -> Responsible for defining the properties and list of enemies in a Map
8. Merge Manager -> Has the responsibility of defining the merging behaviors and process involved in character and weapon merges
9. Player -> Will be act as the actions and inventory of the user throughought the game process
10. Resource -> Defines the properties of the resources and handling or updating of amount  
11. Weapon -> Responsible for defining game_elements.weapons and their behaviors in the game
12. Window -> Responsible for displaying segments of the game process thus making the program easier to read and lessening the responsibilities of the game class

Additional Note: This main/driver class is used for the process of running the Game class' start method. It will utilize an infinite loop for the game's restart feature.

*/

public class Driver {
    public static void main(String[] args) {
        while (true)
        {
            Game game1 = new Game ();
            game1.gameStart();
        }

    }
} 