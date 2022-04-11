package edu.gonzaga;

/*
* Class used to configure Yahtzee rules
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConfigureRules 
{
    private Integer numSides;
    private Integer numDice;
    private Integer numRolls;
    private String fileName;

    public ConfigureRules()
    {
        // Default constructor, generates object to adjust rules
    }    
    
    public Integer[] openConfig()
    {
        this.fileName = System.getProperty("user.dir");
        this.fileName += "/yahtzeeConfig.txt";
        
        this.numSides = 0;
        this.numDice = 0;
        this.numRolls = 0;

        Integer counter = 0;

        try {
            Scanner input = new Scanner(System.in);
            File file = new File(this.fileName);

            input = new Scanner(file);

            while (input.hasNextLine()) 
            {
                if(counter == 0)
                    this.numSides = input.nextInt();
                else if(counter == 1)
                    this.numDice = input.nextInt();
                else if(counter == 2)
                    this.numRolls = input.nextInt();
                else
                    break;

                counter++;
            }

            input.close();

        } 
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        
        System.out.println("Number of sides: " + this.numSides);
        System.out.println("Number of dice: " + this.numDice);
        System.out.println("Number of rolls: " + this.numRolls);
        
        return new Integer[] {numSides, numDice, numRolls};
    }

    

    public Integer[] editConfig()
    {
        Scanner scan = new Scanner(System.in);
        String input = "";
        Boolean valid = false;
        System.out.println("Would you like to edit the current configuration? (Yes/No)");
        input = scan.nextLine();
        if(input.equals("Yes") || input.equals("yes") || input.equals("Y") || input.equals("y"))
        {
            while(!valid)
            {
                System.out.println("Please enter the number of sides for the dice.");
                input = scan.nextLine();
                try
                {
                    this.numSides = Integer.parseInt(input);
                    valid = true;
                }
                catch(NumberFormatException ex)
                {
                    System.out.println("Please enter a valid number.");
                    valid = false;
                }
            }
            valid = false;
            while(!valid)
            {
                System.out.println("Please enter the number of dice.");
                input = scan.nextLine();
                try
                {
                    this.numDice = Integer.parseInt(input);
                    valid = true;
                }
                catch(NumberFormatException ex)
                {
                    System.out.println("Please enter a valid number.");
                    valid = false;
                }
            }
            valid = false;
            while(!valid)
            {
                System.out.println("Please enter the number of rolls.");
                input = scan.nextLine();
                try
                {
                    this.numRolls = Integer.parseInt(input);
                    valid = true;
                }
                catch(NumberFormatException ex)
                {
                    System.out.println("Please enter a valid number.");
                    valid = false;
                }
            }
        }
        return new Integer[] {numSides, numDice, numRolls};
    }
    public void saveConfig()
    {
        try {
            FileWriter file = new FileWriter(this.fileName);
            file.write(this.numSides + "\n");
            file.write(this.numDice + "\n");
            file.write(this.numRolls + "\n");
            file.close();
        } 
            catch (IOException ex) 
            {
                ex.printStackTrace();
            }
    }
}