package com.company;

// This class validates a command line argument to ensure 
// it is an integer in the specified range.

public class InputValidator {

    private String input;            // String representation from commmand line
    private int lowerBound = -1000;  // Default lower bound
    private int upperBound = 1000;   // Default upper bound
    private String usageText;        // Text to display on error
    private int number;              // Sanitized input integer

    // Constructor
    public InputValidator(String arg, int lower, int upper, String usage)
    {
        input = arg;

        if (upper > lower) {
            lowerBound = lower;
            upperBound = upper;
        }
      
        usageText = usage;
    }

    // Public validation method
    public boolean validate()
    {
        if (!inputIsInteger()) {
            System.out.println("Error: Input is not an integer");
            System.out.println(usageText);
            return false;
        }

        if (!numberInRange()) {
            System.out.println("Error: Number is out of range");
            System.out.println(usageText);
            return false;
        }

        return true;
    }

    // Check if input parses as an integer.
    private boolean inputIsInteger() 
    {
        try {
            number = Integer.parseInt(input);
        }
        catch(NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    // Check if input is in the specified range.
    private boolean numberInRange() 
    {
        return ((number >= lowerBound) && (number <= upperBound));
    }

    // Return resulting integer.
    public int getNumber() 
    {
        return number;
    }
}
