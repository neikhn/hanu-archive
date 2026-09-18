package section3;

import java.util.Scanner;

public class Act2 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the year: ");
        int year = sc.nextInt();
        sc.close();
        if (year % 4 != 0) {
            System.out.println("Not a leap year");
        } else if (year % 100 == 0 && year % 400 != 0) {
            System.out.println("Not a leap year");
        } else {System.out.println("Leap year");}
    }
}
