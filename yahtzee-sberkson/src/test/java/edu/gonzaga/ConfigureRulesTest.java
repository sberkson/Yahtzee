package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ConfigureRulesTest 
{
    @Test
    void checkOpenConfig()
    {
        ConfigureRules config = new ConfigureRules();
        Integer[] configuration = config.openConfig();
        Integer length = configuration.length;
        assertTrue(length == 3);
    }
}
