package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ScorecardTest 
{
    @Test
    void checkConstructor()
    {
        Scorecard score = new Scorecard();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        ArrayList<Integer> test = score.getScores();

        for(int i = 0; i < 5; i++)
        {
            scores.add(0);
            assertEquals(test.get(i), scores.get(i));
        }
    }
}
