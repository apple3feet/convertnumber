package com.company;

// This command accepts an integer and converts it to a textual 
// representation, e.g.
//    java -jar ConvertNumber.jar 100 (output is: one hundred)

public class Main {

    public static void main(String[] args)
    {
        int lowerBound = -999999;  // Full int range: -2147483648
        int upperBound = 999999;   // Full int range: 2147483647

        String usage = "Usage: java -jar ConvertNumber.jar <integer in range " +
                       lowerBound + " to " + upperBound + ">";

        // This command accepts one argument.
        if (args.length != 1) {
            System.out.println(usage);
            return;
        }

        // Validate the input.
        InputValidator val = new InputValidator(args[0], lowerBound,
                                                upperBound, usage);
        if (!val.validate()) {
            // Errors and usage information have already been printed
            return;
        }

        // We have a valid integer, so convert it to a string.
        NumberConverter con = new NumberConverter(val.getNumber());
        System.out.println(con.convert());
    }
}
