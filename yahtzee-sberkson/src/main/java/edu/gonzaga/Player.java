/* (C)2021 */
package edu.gonzaga;

/*
* Class for a Player used in Yahtzee.

* Principally used to tie a hand and scorecard together under a single identifier.  Allows for portability between single and multi player functionalities.

*/

public class Player 
{
    private String name;
    public Hand hand;
    public Scorecard scorecard;

    public Player()
    {      
        this.name = "";
        this.hand = new Hand();
        this.scorecard = new Scorecard(hand);
    }

    public Player(Integer numSides, Integer numDice, Integer numRolls)
    {
        this.name = "";
        this.hand = new Hand(numDice, numSides);
        this.scorecard = new Scorecard(hand);
    }

    /*8
    * Sets player name to input
    *
    * @param name to assign to player
    */
    public void setName(String name)
    {
        this.name = name;
    }

    /*
    * Returns player name
    *
    * @return String name
    */
    public String getName()
    {
        return this.name;
    }

    
}
