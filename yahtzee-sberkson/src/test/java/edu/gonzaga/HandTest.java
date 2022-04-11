package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HandTest {
    @Test
    void alwaysTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    void generateHand() {
        Hand hand = new Hand();
        assertEquals(6, hand.getNumDice());
        Hand hand2 = new Hand(20, 20);
        hand2.rollHand();
        assertEquals(20, hand2.getNumDice());
    }

    @Test
    void generateHandWithSides() {
        Hand hand = new Hand(25, 3);
        assertEquals(25, hand.getNumDice());
        assertEquals(3, hand.getNumSides());
    }

    @Test
    void testGetDie() {
        Hand hand = new Hand(6, 1);
        assertEquals(1, hand.getDie(0));
        assertEquals(1, hand.getDie(1));
        assertEquals(1, hand.getDie(2));
        assertEquals(1, hand.getDie(3));
        assertEquals(1, hand.getDie(4));
        assertEquals(1, hand.getDie(5));
    }
    
  
}
