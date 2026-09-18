package section3.Exercise5_6;

import java.util.Scanner;

public class ArrayCalculator {
    public static void divide(int[] a, int[] b) {
        if (a.length < b.length) {
            throw new IndexOutOfBoundsException("The array b has insufficient elements for array a");
        }

        System.out.println();
        // System.out.println("+-------+-------+-------+");
        System.out.println("|   a   |   b   | Result|");
        System.out.println("+-------+-------+-------+");

        for (int i = 0; i < a.length; i++) {
            try {
                int result = a[i] / b[i];
                System.out.printf("|%7d|%7d|%7d|%n", a[i], b[i], result);
            } catch (ArithmeticException e) {
                System.out.printf("|%7d|%7d|%7s|%n", a[i], b[i], "ERROR");
            } catch (IndexOutOfBoundsException e) { // out of bound elements displayed as "MISSING"
                System.out.printf("|%7d|%7s|%7s|%n", a[i], "MISSING", "MISSING");
                System.out.println();
                // System.out.println("+-------+-------+-------+");
                System.out.println("Array b has insufficient elements. Do you want to provide missing values? (y/n)");
                
                Scanner sc = new Scanner(System.in);
                String choice = sc.nextLine();
                
                if (choice.equalsIgnoreCase("y")) { //handle for when the user input upper and lower case
                    System.out.print("Enter missing b values separated by spaces: ");
                    String input = sc.nextLine();
                    String[] missingValues = input.split(" "); // remove spaces, take input(s) into @missingValues[]

                    for (String value : missingValues) {
                        // since @missingValues[] are String, filtered casting is nescessary
                        // converting string into representable numeric value
                        int intValue = Integer.parseInt(value); 
                        b = addElement(b, intValue);
                    }
                    // sc.next();
                    System.out.println("Continuing calculation with added values.");
                    divide(a, b);
                } else {
                    System.out.println("Calculation stopped.");
                    break;
                }
            }
        }
        // System.out.println("+-------+-------+-------+");
        // sc.close();
    }
    
    /**
     * Fill in missing value using input taken from user
     * 
     * @param array
     * @param value
     * @effects 
     *      
     */
    private static int[] addElement(int[] array, int value) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        return newArray;
    }
}
