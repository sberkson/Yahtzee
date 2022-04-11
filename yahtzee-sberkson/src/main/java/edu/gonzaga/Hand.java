/* (C)2021 */
package edu.gonzaga;

/*
* Class for a Hand used in Yahtzee.
*/

import java.util.ArrayList;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;


public class Hand implements PropertyChangeListener 
{
    private ArrayList<Die> hand = new ArrayList<Die>();
    private Integer numSides;
    private Integer numDice;

    public Hand()
    {
        for(int i = 0; i < 5; i++)
        {
            this.hand.add(new Die(6));
            this.hand.get(i).roll();
            this.hand.get(i).addPropertyChangeListener(this::propertyChange);
        }
        this.numDice = 6;
        this.numSides = 6;
    }

    public Hand(Integer numDice, Integer numSides)
    {
        this.numSides = numSides;
        this.numDice = numDice;

        for(int i = 0; i < numDice; i++)
        {
            this.hand.add(new Die(numSides));
            this.hand.get(i).roll();
        }
    }
    
    public void propertyChange(PropertyChangeEvent e)
    {
        String propertyName = e.getPropertyName();
        if("dievalue".equals(propertyName))
        {
            System.out.println("Die changed to: " + e.getNewValue());
        }
    }

    public Die getDieAt(int index)
    {
        return this.hand.get(index);
    }

    public void roll()
    {
        for(int i = 0; i < this.numDice; i++)
        {
            this.hand.get(i).roll();
        }
    }

    public void rollHand()
    {
        for(int i = 0; i < this.numDice; i++)
        {
            this.hand.get(i).roll();
        }
    }

    public void keepHand(String keeps)
    {
        for(int i = 0; i < keeps.length(); i++)
        {
            if(keeps.charAt(i) == 'n')
            {
                this.hand.get(i).roll();
            }
        }
    }
    
    public Integer getDie(int index)
    {   
        return this.hand.get(index).getSideUp();
    }

    public Integer getNumDice()
    {
        return this.numDice;
    }

    public Integer getNumSides()
    {
        return this.numSides;
    }

    public void print()
    {
        System.out.print("Here is your hand: ");

        for(int i = 0; i < this.numDice; i++)
        {   
            System.out.print(this.hand.get(i) + " ");
        }
    }

    public String toString()
    {
        String ret = "";
        ret += "Hand: ";
        for(int i = 0; i < this.numDice; i++)
        {
            ret += this.hand.get(i).toString() + " | ";
        }
        
        return ret;
    }
}
