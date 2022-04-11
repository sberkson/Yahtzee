/* (C)2021 */
package edu.gonzaga;

/*
* Class for a Die used in Yahtzee.
*/

import java.util.Random;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

/** Class to store the state of a single die. */
public class Die implements Comparable<Die> {
    private Integer sideUp; // Current die 'value' in range 1..numSides
    private Integer numSides; // Sides on the die (should be 1...INF integer)
    private static final Integer DEFAULT_NUM_SIDES = 6;
    private static final Integer DEFAULT_SIDE_UP = 1;
    boolean locked = false;
    int value = 0;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
    
    public void lock() {
        locked = true;
    }

    public void unlock() {
        locked = false;
    }


    public Die() {
        this.numSides = DEFAULT_NUM_SIDES;
        this.sideUp = DEFAULT_SIDE_UP;
    }

    public Die(Integer numSides) {
        this.numSides = numSides;
        this.sideUp = DEFAULT_SIDE_UP;
    }

    public Die(Integer numSides, Integer startingSide) {
        this.numSides = numSides;
        this.sideUp = startingSide;
    }

    /** Rolls the die once, getting new random value. */
    public void roll() 
    {   
        if(!locked)
        {
            Random rand = new Random();
            this.sideUp = rand.nextInt(this.numSides) + 1;
            
            Integer upperbound = 6;
            this.setValue(rand.nextInt(upperbound) + 1);
        }
    }

    private void setValue(int newValue)
    {
        int oldValue = this.value;
        this.value = newValue;
        this.pcs.firePropertyChange("dievalue", oldValue, newValue);
    }

    public int getValue() {
        return value;
    }
    /**
    * Returns current die value (the side that's up).
    *
    * @return Integer Current Die's Side Up
    */
    public Integer getSideUp() {
        return this.sideUp;
    }

    /**
    * Returns quantity of sides on the die.
    *
    * @return Integer number of sides on the die
    */
    public Integer getNumSides() {
        return this.numSides;
    }

    /**
    * Provides the ability to convert the Die object into a string. representation, both with
    * .toString(), but also in System.out.println()
    *
    * @return String of whatever you want this die to say for itself
    */
    @Override
    public String toString() {
        String ret = "";
        // ret += "Die: " + this.sideUp.toString() + " of " + this.numSides.toString() + " sides";
        ret += this.sideUp.toString();
        return ret;
    }

    /**
    * Makes two dice comparable using <, ==, >, etc. based on sideUp values.
    *
    * @param otherDie The die we're comparing to this one (two objects)
    * @return int -1, 0, 1 for less than, equal, greater than
    */
    @Override
    public int compareTo(Die otherDie) {
        return this.sideUp.compareTo(otherDie.sideUp);
    }
}
