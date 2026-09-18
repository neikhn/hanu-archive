package section3;
import java.util.Scanner;
public class Act3 {
    public static void main(String[] args) {
        Scanner act3 = new Scanner(System.in);
        System.out.println("Enter the two numbers separated by a space: ");
        double firstNumber = act3.nextDouble();
        double secondNumber = act3.nextDouble();
        act3.close();
        double processFirst = Math.floor(firstNumber * 100);
        double processSecond = Math.floor(secondNumber * 100);
        System.out.println(processFirst + " + " + processSecond);
        if (processFirst == processSecond) {
            System.out.println("They are the same up to 2 decimal places.");
        } else {
            System.out.println("They are not the same up to 2 decimal places.");
        }
    }
}
