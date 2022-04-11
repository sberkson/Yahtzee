package edu.gonzaga;

/*

* Driver class for game loop
* In practice, Game.java hosts the functionality of our Yahtzee game.  All it is missing is our configuration class, but these values are passed in via overloading the constructor.  
* playGame() runs the game loop, handling turns and interfacing with other necessary classes (Hand.java, Scorecard.java, Player.java).

*/

import java.util.*;

public class Game 
{
    private Player player;
    private Integer numSides, numDice, numRolls;

    public Game()
    {
        player = new Player();
        this.numSides = 6;
        this.numDice = 5;
        this.numRolls = 3;
    }

    public Game(Integer numSides, Integer numDice, Integer numRolls)
    {
        this.numSides = numSides;
        this.numDice = numDice;
        this.numRolls = numRolls;
        player = new Player(numSides, numDice, numRolls);
    }

    /**
    * Returns number of sides per die used in current game
    *
    * @return Integer numSides
    */
    public Integer getNumSides()
    {
        return this.numSides;
    }

    /**
    * Returns number of die used in current game
    *
    * @return Integer numDice
    */
    public Integer getNumDice()
    {
        return this.numDice;
    }

    /**
    * Returns number of rolls per turn used in current game
    *
    * @return Integer numRolls
    */
    public Integer getNumRolls()
    {
        return this.numRolls;
    }

    /**
    * Handles main Yahtzee single player game loop
    *
    */
    public void playGame()
    {
        ArrayList<String> categories = new ArrayList<String>();
        System.out.println("Welcome to Yahtzee!");
        Scanner scan = new Scanner(System.in);
        String input = "Yes";

        while(input.equals("Yes") || input.equals("yes") || input.equals("Y") || input.equals("y")) 
        {
            Integer rolls = 0;
            Boolean roll = true;
            
 
            System.out.println("Press S to see your current scorecard, or press any other key to roll.");
            input = scan.nextLine();

            if(input.equals("S") || input.equals("s"))
            {
                player.scorecard.printScores();
            }


            while(rolls < numRolls && roll)
            {
                if(rolls == 0)
                {
                    player.hand.rollHand();
                }
                
                player.hand.print();

                System.out.println("\nWould you like to roll again? (Yes/No)");
                input = scan.nextLine();
                if(input.equals("Yes") || input.equals("yes") || input.equals("Y") || input.equals("y"))
                {
                    roll = true;
                }
                else
                {
                    roll = false;
                    break;
                }
                
                player.hand.print();
                System.out.println("Would you like to keep any die? Please input in the following format: ynyny.");
                String keep = scan.nextLine();
                player.hand.keepHand(keep);
                rolls++;
            }

            player.scorecard.scoring();
            player.scorecard.printScores();
            System.out.println("Which line would you like to score? ");
            String category = scan.nextLine();
            categories.add(category);
            player.scorecard.getScoreline(categories);
            input = "Yes";
        } 

        System.out.println("Would you like to play again? Yes/No");
        input = scan.nextLine();
        if(input.equals("Yes") || input.equals("yes") || input.equals("Y") || input.equals("y"))
        {
            Game game = new Game();
            game.playGame();
        }
        
        System.out.println("Goodbye!");
    }
    
}
