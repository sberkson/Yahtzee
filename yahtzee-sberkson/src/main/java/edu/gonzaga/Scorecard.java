/* (C)2021 */
package edu.gonzaga;

/*
* Class for a Scorecard used in Yahtzee.
*/

import java.util.ArrayList;

public class Scorecard 
{
    private Hand hand;
    private ArrayList<String> categories;
    public ArrayList<String> removedCategories;
    private ArrayList<Integer> scores;
    private Integer totalScore;

    public Scorecard()
    {
        this.hand = new Hand();
        this.categories = new ArrayList<String>(5);
        this.scores = new ArrayList<Integer>(5);
        removedCategories = new ArrayList<String>();
        this.totalScore = 0;

        for(int i = 0; i < 5; i++)
        {
            this.scores.add(0);
            this.categories.add(String.valueOf(i));
        }
        
        this.categories.add("Three of a kind");
        this.categories.add("Four of a kind");
        this.categories.add("Full House");
        this.categories.add("Small Straight");
        this.categories.add("Large Straight");
        this.categories.add("Yahtzee");
        this.categories.add("Chance");

    }

    public Scorecard(Hand inputHand)
    {
        this.hand = inputHand;
        this.categories = new ArrayList<String>(5);
        this.scores = new ArrayList<Integer>(5);
        removedCategories = new ArrayList<String>();
        this.totalScore = 0; // initializations

        for(int i = 0; i < (this.hand.getNumSides() + 7); i++)
            scores.add(0); // adds dummy values to set up valid indexing range for numerical scores

        for(int i = 1; i <= this.hand.getNumSides(); i++)
            this.categories.add(String.valueOf(i)); // initializes valid indices in categories list, adding numerical identifiers as strings

        this.categories.add("Three of a kind");
        this.categories.add("Four of a kind");
        this.categories.add("Full House");
        this.categories.add("Small Straight");
        this.categories.add("Large Straight");
        this.categories.add("Yahtzee");
        this.categories.add("Chance"); 
    }

    public ArrayList<Integer> getScores()
    {
        return this.scores; // returns list of scores
    }

    public Integer getTotalScore()
    {
        return this.totalScore; // returns total score
    }

    public void scoring()
    {
        upperScorecard();
        lowerScorecard();
        for(int i = 0; i < this.removedCategories.size(); i++)
        {
            Integer index = this.categories.indexOf(this.removedCategories.get(i));
            this.categories.remove(index);
            this.scores.remove(index);
        } // redundant removal, failsafe
    }

    public void printScores()
    {   
        Integer removed = 0;
        for(int i = 0; i < this.removedCategories.size(); i++)
        {
            Integer index = this.categories.indexOf(this.removedCategories.get(i));
            this.categories.remove(index);
            this.scores.remove(index);
            removed++;
        } // failsafe removal of scoreline
        
        for(int i = 0; i < this.categories.size(); ++i)
        {   if(this.removedCategories.contains(this.categories.get(i)))
            {
                continue; // dont print current iteration, skip to next iteration
            }
            System.out.println(this.categories.get(i) + ": " + this.scores.get(i));
        }
    }

    public void getScoreline(ArrayList<String> removeMe)
    {
        this.removedCategories = removeMe;

        for(int i = 0; i < removeMe.size(); i++)
        {
            Integer index = this.categories.indexOf(removeMe.get(i)); // grabs index for removal
            this.categories.remove(index);
            this.scores.remove(index); // removes scoreline from parallel lists
        }
    
    }

    public void lowerScorecard()
    {   
        Integer i = 0;

        for(i = 0; i < this.hand.getNumSides(); i++)
        {
            // simple iterator to update i to correct index for scores insertion
        }

        this.scores.set(i, threeOfAKind());
        this.scores.set(i + 1, fourOfAKind());
        this.scores.set(i + 2, fullHouse());
        this.scores.set(i + 3, smallStraight());
        this.scores.set(i + 4, largeStraight());
        this.scores.set(i + 5, yahtzee());
        this.scores.set(i + 6, chance());
    }

    public Integer threeOfAKind()
    {
        Integer score = 0;

        if(this.hand.getNumDice() < 3)
        {
           return 0;
        }
        else
        {
            for(int i = 0; i < this.hand.getNumDice(); i++)
            {
                for(int j = i + 1; j < this.hand.getNumDice(); j++)
                {
                    for(int k = j + 1; k < this.hand.getNumDice(); k++)
                    {
                        if(this.hand.getDie(i) == this.hand.getDie(j) && this.hand.getDie(i) == this.hand.getDie(k))
                        {
                            score = this.hand.getDie(i) * 3;
                        }
                    }
                }
            }
        }

        return score;
    }

    public Integer fourOfAKind()
    {
        Integer score = 0;

        if(this.hand.getNumDice() < 4)
        {
            return 0;
        }
        else
        {
            for(int i = 0; i < this.hand.getNumDice(); i++)
            {
                for(int j = i + 1; j < this.hand.getNumDice(); j++)
                {
                    for(int k = j + 1; k < this.hand.getNumDice(); k++)
                    {
                        for(int l = k + 1; l < this.hand.getNumDice(); l++)
                        {
                            if(this.hand.getDie(i) == this.hand.getDie(j) && this.hand.getDie(i) == this.hand.getDie(k) && this.hand.getDie(i) == this.hand.getDie(l))
                            {
                                score = this.hand.getDie(i) * 4;
                            }
                        }
                    }
                }
            }
        }

        return score;
    }

    public Integer fullHouse()
    {
        Integer score = 0;

        if(this.hand.getNumDice() < 3)
        {
            return 0;
        }
        else
        {
            for(int i = 0; i < this.hand.getNumDice(); i++)
            {
                for(int j = i + 1; j < this.hand.getNumDice(); j++)
                {
                    for(int k = j + 1; k < this.hand.getNumDice(); k++)
                    {
                        if(this.hand.getDie(i) == this.hand.getDie(j) && this.hand.getDie(i) == this.hand.getDie(k))
                        {
                            for(int l = k + 1; l < this.hand.getNumDice(); l++)
                            {
                                if(this.hand.getDie(i) != this.hand.getDie(l))
                                {
                                    score = this.hand.getDie(i) + this.hand.getDie(l);
                                }
                            }
                        }
                    }
                }
            }
        }

        return score;
    }

    public Integer smallStraight()
    {
        Integer score = 0;

        if(this.hand.getNumDice() < 4)
        {
            return 0;
        }
        else
        {
            for(int i = 0; i < this.hand.getNumDice(); i++)
            {
                for(int j = i + 1; j < this.hand.getNumDice(); j++)
                {
                    for(int k = j + 1; k < this.hand.getNumDice(); k++)
                    {
                        for(int l = k + 1; l < this.hand.getNumDice(); l++)
                        {
                            if(this.hand.getDie(i) == 1 && this.hand.getDie(j) == 2 && this.hand.getDie(k) == 3 && this.hand.getDie(l) == 4)
                            {
                                score = 15;
                            }
                        }
                    }
                }
            }
        }
        return score;
    }

    public Integer largeStraight()
    {
        Integer score = 0;

        if(this.hand.getNumDice() < 5)
        {
            return 0;
        }
        else
        {
            for(int i = 0; i < this.hand.getNumDice(); i++)
            {
                for(int j = i + 1; j < this.hand.getNumDice(); j++)
                {
                    for(int k = j + 1; k < this.hand.getNumDice(); k++)
                    {
                        for(int l = k + 1; l < this.hand.getNumDice(); l++)
                        {
                            for(int m = l + 1; m < this.hand.getNumDice(); m++)
                            {
                                if(this.hand.getDie(i) == 1 && this.hand.getDie(j) == 2 && this.hand.getDie(k) == 3 && this.hand.getDie(l) == 4 && this.hand.getDie(m) == 5)
                                {
                                    score = 20;
                                }
                            }
                        }
                    }
                }
            }
        }

        return score;
    }

    public Integer yahtzee()
    {
        Integer score = 0;

        if(this.hand.getNumDice() < 5)
            return 0;

        else
        {
            for(int i = 0; i < this.hand.getNumDice(); i++)
            {
                for(int j = i + 1; j < this.hand.getNumDice(); j++)
                {
                    for(int k = j + 1; k < this.hand.getNumDice(); k++)
                    {
                        for(int l = k + 1; l < this.hand.getNumDice(); l++)
                        {
                            for(int m = l + 1; m < this.hand.getNumDice(); m++)
                            {
                                if(this.hand.getDie(i) == this.hand.getDie(j) && this.hand.getDie(i) == this.hand.getDie(k) && this.hand.getDie(i) == this.hand.getDie(l) && this.hand.getDie(i) == this.hand.getDie(m))
                                {
                                    score = 50;
                                }
                            }
                        }
                    }
                }
            }
        }

        return score;
    }

    public Integer chance()
    {
        Integer score = 0;

        for(int i = 0; i < this.hand.getNumDice(); i++)
            score += this.hand.getDie(i);

        return score;
    }

    public void upperScorecard()
    {
        for(int i = 1; i <= this.hand.getNumSides(); i++)
        {
            Integer score = 0;

            for(int j = 0; j < this.hand.getNumDice(); j++)
            {
                if(this.hand.getDie(j) == i)
                {
                    score += this.hand.getDie(j);
                    this.scores.set((i - 1), score);
                    this.totalScore += score;
                }
            }

            if(score == 0)
                this.scores.set((i - 1), 0);
        }

        for(int i = 0; i < 7; i++)
            this.scores.add(0);
    }
}
