package section1.Exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise1 {
    private ArrayList<Integer> nums = new ArrayList<>();

    public void collectUserInput() {
        Scanner sc = new Scanner(System.in);

        boolean validInput = false;
        int arrayElement = 0;
        
        while (!validInput) { // Error handling for arrayElement input
            try {
                System.out.print("Input amount of integer(s): ");
                arrayElement = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input! Enter a valid integer.");
                sc.next(); // Clear invalid input from scanner 
            }
        }

        for (int i = 0; i < arrayElement; i++) {
            validInput = false;
            while (!validInput) { // Error handling for individual integer input
                try {
                    System.out.print("Inserting integer to ArrayList: ");
                    nums.add(sc.nextInt());
                    validInput = true;
                } catch (InputMismatchException exception) {
                    System.out.println("Invalid input! Enter a valid integer.");
                    sc.next(); // Clear invalid input from scanner 
                }
            }
        }
        
        sc.close();
    }

    public boolean repOk() {
        for (Integer i : nums) {
            if (i == null) {
                return false;
            }
        }
        return true;
    }

    public void displayArrayListContent() {
        System.out.print("ArrayList: [ ");
        for (Integer i : nums) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

    public void displayResult() {
        displayArrayListContent();

        if (repOk()) {
            System.out.println("Min: " + Collections.min(nums));
            System.out.println("Max: " + Collections.max(nums));
        } else {
            System.out.println("ArrayList containing null value(s)");
        }
    }

    public static void main(String[] args) {
        Exercise1 exercise = new Exercise1();

        exercise.collectUserInput();
        exercise.displayResult();
    }
}
