package section3;
import java.util.Scanner;
public class Act4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quadratic equation: ax2 + bx + c = 0");
        System.out.print("Input 3 real numbers: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        sc.close();
        double partOfX = b * b - 4 * a * c;
        if (a == 0 && b == 0 && c == 0) {
            System.out.println("There's nothing to be solve.");
        } else if (a == 0 && b == 0) {
            System.out.println("The equation has no root.");
        } else if (a == 0) {
            double x = - c / b;
            System.out.println("There is one root: " + x);
        } else if (partOfX < 0) {
            System.out.println("The equation has no real root.");
        } else {
            double x1 = ((- b + Math.sqrt(partOfX)) / (2 * a));
            double x2 = ((- b - Math.sqrt(partOfX)) / (2 * a));
            System.out.println(" There are two roots, the first one being x1 = " + x1);
            System.out.println(" The second one being x2 = " + x2);
        }
    }
}
