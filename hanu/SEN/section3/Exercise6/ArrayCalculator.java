package section3.Exercise6;

import java.util.*;

class CustomIndexOutOfBoundsException extends Exception {
    public CustomIndexOutOfBoundsException() {
        super("Custom IndexOutOfBoundsException: Array b has insufficient elements");
    }
}

class CustomArithmeticException extends Exception {
    public CustomArithmeticException() {
        super("Custom ArithmeticException: Division by zero or other arithmetic error");
    }
}

public class ArrayCalculator {
    public static void divide(int[] a, int[] b) throws CustomIndexOutOfBoundsException, CustomArithmeticException {
        if (a.length > b.length) {
            throw new CustomIndexOutOfBoundsException();
        }

        System.out.println("|   a   |   b   | Result|");
        System.out.println("+-------+-------+-------+");

        for (int i = 0; i < a.length; i++) {
            try {
                int result = a[i] / b[i];
                System.out.printf("|%7d|%7d|%7d|%n", a[i], b[i], result);
            } catch (ArithmeticException e) {
                throw new CustomArithmeticException();
            } catch (IndexOutOfBoundsException e) {
                System.out.printf("|%7d|%7s|%7s|%n", a[i], "MISSING", "MISSING");
                System.out.println("+-------+-------+-------+");
                System.out.println("Array b has insufficient elements. Do you want to provide missing values? (y/n)");

                Scanner sc = new Scanner(System.in);
                String choice = sc.nextLine();

                if (choice.equalsIgnoreCase("y")) {
                    System.out.print("Enter missing b values separated by spaces: ");
                    String input = sc.nextLine();
                    String[] missingValues = input.split(" ");

                    for (String value : missingValues) {
                        int intValue = Integer.parseInt(value);
                        b = addElement(b, intValue);
                    }

                    System.out.println("Continuing calculation with added values.");
                    divide(a, b);
                } else {
                    System.out.println("Calculation stopped.");
                    break;
                }
            }
        }
    }

    private static int[] addElement(int[] array, int value) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        return newArray;
    }
}
