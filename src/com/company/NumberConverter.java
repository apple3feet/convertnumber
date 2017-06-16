package com.company;

// This class converts a validated integer to a textual representation.
// For example, 12001 converts to: twelve thousand one

public class NumberConverter {

    private int    number;                        // Sanitized input integer
    private String numberText = "";               // Number converted to text
    private String negativePrefix = "negative";   // One might prefer "minus"
    private int    billion  = 1000000000;         // For support of int range
    private int    million  = 1000000;
    private int    thousand = 1000;

    public NumberConverter(int inputNumber)
    {
        number = inputNumber;
    }

    // This method converts the integer to a string. The string is built in
    // the numberText class variable. This method returns the final string.
    public String convert()
    {
        // Handle negative numbers first
        if (number < 0) {
            numberText = negativePrefix + " ";
            number = Math.abs(number);
        }

        // Handle Java int range (-2,147,483,648 to 2,147,483,647).
        // These methods append to numberText as necessary.
        handleBillions();
        handleMillions();
        handleThousands();
        handleOnes();
        
        // Get rid of leading and trailing spaces.
        numberText = numberText.trim();

        return numberText;
    }

    // This method handles the billions digits.
    private void handleBillions()
    {
        if (number >= billion) {
            threeDigitsToText(number / billion);
            numberText += "billion ";
        }
    }

    // This method handles the millions digits.
    private void handleMillions()
    {
        int num = number % billion;

        if (num >= million) {
            threeDigitsToText(num / million);
            numberText += "million ";
        }
    }

    // This method handles the thousands digits.
    private void handleThousands()
    {
        int num = number % million;

        if (num >= thousand) {
            threeDigitsToText(num / thousand);
            numberText += "thousand ";
        }
    }

    // This method handles numbers in the range 0 to 999.
    private void handleOnes()
    {
        if (number > 0) {
            threeDigitsToText(number % 1000);
        } else {
            numberText = "zero ";
        }
    }

    // Add textual digits for a number from 1 to 999
    private void threeDigitsToText(int num)
    {
        // Add the number of hundreds
        if (num >= 100) {
            int hundreds = num / 100;
            oneDigitToText(hundreds);
            numberText += "hundred ";
        }

        // Add the rest of the number (tens and/or ones)
        int tens = num % 100;
        if (tens > 0) {
            twoDigitsToText(tens);
        }
    }

    // Add textual digits for a number from 1 to 99
    private void twoDigitsToText(int num)
    {
        // Add number of tens
        int tens = num / 10;
        switch (tens) {
            case 0:  break;
            case 1:  if (num == 10) {
                         numberText += "ten ";
                     } else {
                         // Special handling for teen numbers
                         teenText(num);
                         return;
                     }
                     break;
            case 2:  numberText += "twenty ";
                     break;
            case 3:  numberText += "thirty ";
                     break;
            case 4:  numberText += "forty ";
                     break;
            case 5:  numberText += "fifty ";
                     break;
            case 6:  numberText += "sixty ";
                     break;
            case 7:  numberText += "seventy ";
                     break;
            case 8:  numberText += "eighty ";
                     break;
            case 9:  numberText += "ninety ";
                     break;
            default: numberText += "UnexpectedTen:" + tens + " ";
                     break;
        }

        // Add the rest of the number (ones)
        int ones = num % 10;
        if (ones > 0) {
            oneDigitToText(ones);
        }
    }

    // Add textual digits for a number from 11 to 19
    private void teenText(int num)
    {
        int ones = num % 10;

        switch (ones) {
            case 1:  numberText += "eleven ";
                     break;
            case 2:  numberText += "twelve ";
                     break;
            case 3:  numberText += "thirteen ";
                     break;
            case 4:  numberText += "fourteen ";
                     break;
            case 5:  numberText += "fifteen ";
                     break;
            case 6:  numberText += "sixteen ";
                     break;
            case 7:  numberText += "seventeen ";
                     break;
            case 8:  numberText += "eighteen ";
                     break;
            case 9:  numberText += "nineteen ";
                     break;
            default: numberText += "UnexpectedTeen:" + ones + " ";
                     break;
        }
    }

    // Add textual digits for a number from 1 to 9
    private void oneDigitToText(int num)
    {
        switch (num) {
            case 0:  break;
            case 1:  numberText += "one ";
                     break;
            case 2:  numberText += "two ";
                     break;
            case 3:  numberText += "three ";
                     break;
            case 4:  numberText += "four ";
                     break;
            case 5:  numberText += "five ";
                     break;
            case 6:  numberText += "six ";
                     break;
            case 7:  numberText += "seven ";
                     break;
            case 8:  numberText += "eight ";
                     break;
            case 9:  numberText += "nine ";
                     break;
            default: numberText += "UnexpectedOne:" + num + " ";
                     break;
        }
    }
}
