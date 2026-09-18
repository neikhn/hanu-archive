package section3;
import java.util.Scanner;

public class Act1 {
    public static void main(String[] args) {
        System.out.print("Please enter a real number: ");
        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();
        sc.close();
        if (number == 0) {
            System.out.println("The number is zero.");
        } else if (number > 0) {
            if (number < 1) {
                System.out.println("A small positive number.");
            } else if (number > 1000000) {
                System.out.println("A large positive number.");
            } else {
                System.out.println("A positive number.");
            }
        } else {
            if (number > -1) {
                System.out.println("A small negative number.");
            } else if (number < -1000000) {
                System.out.println("A large negative number.");
            } else {
                System.out.println("A negative number.");
            }
        }
    }
}