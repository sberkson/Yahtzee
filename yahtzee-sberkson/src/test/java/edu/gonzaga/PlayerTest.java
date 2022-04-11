package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PlayerTest 
{
    @Test
    void checkName()
    {
        Player player = new Player();
        player.setName("Crandall");
        String name = player.getName();

        assertEquals("Crandall", name);
    }

}
