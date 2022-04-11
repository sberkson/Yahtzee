/* (C)2021 */
package edu.gonzaga;

/*
*  This is the main class for the Yahtzee project.
*  It really should just instantiate another class and run
*   a method of that other class.
*/

/** Main program class for launching Yahtzee program. */
public class Yahtzee {
    public static void main(String[] args) 
    {
        ConfigureRules rules = new ConfigureRules();
        Integer[] config = rules.openConfig();
        //config = rules.editConfig();
        Integer numSides = config[0], numDice = config[1], numRolls = config[2];
        
        Game game = new Game(numSides, numDice, numRolls);
        //game.playGame();
        YahtzeeGUI gui = new YahtzeeGUI(game);
        rules.saveConfig();
    }
}
