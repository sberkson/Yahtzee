package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameTest 
{
    @Test
    void checkConstructor()
    {
        Game game = new Game();
        Integer numSides = game.getNumSides();
        Integer numDice = game.getNumDice();
        Integer numRolls = game.getNumRolls();

        assertEquals(6, numSides);
        assertEquals(5, numDice);
        assertEquals(3, numRolls);

    }

    @Test
    void checkOverloadConstructor()
    {
        Game game = new Game(6, 6, 6);
        Integer numSides = game.getNumSides();
        Integer numDice = game.getNumDice();
        Integer numRolls = game.getNumRolls();

        assertEquals(6, numSides);
        assertEquals(6, numDice);
        assertEquals(6, numRolls);
    }
}
