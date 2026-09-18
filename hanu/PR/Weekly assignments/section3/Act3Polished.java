package section3;
import java.util.Scanner;
public class Act3Polished {
    public static void main(String[] args) {
        Scanner act3 = new Scanner(System.in);
        System.out.print("Enter the two numbers separated by a space: ");
        double firstNumber = act3.nextDouble();
        double secondNumber = act3.nextDouble();
        act3.close();
        String firstNumberAsString = String.valueOf(firstNumber);
        String secondNumberAsString = String.valueOf(secondNumber);
        int indexOfFirstNumber = firstNumberAsString.indexOf(".");
        int indexOfSecondNumber = secondNumberAsString.indexOf(".");
        System.out.println("First double number: " + firstNumber);
        System.out.println("Integer part: " + firstNumberAsString.substring(0,indexOfFirstNumber));
        System.out.println("Decimal part: " + firstNumberAsString.substring(indexOfFirstNumber, 3+ indexOfFirstNumber));
        System.out.println("Second double number: " + secondNumber);
        System.out.println("Integer part: " + secondNumberAsString.substring(0,indexOfSecondNumber));
        System.out.println("Decimal part: " + secondNumberAsString.substring(indexOfSecondNumber, 3+ indexOfSecondNumber));
        if (firstNumberAsString.substring(0,indexOfFirstNumber).equals(secondNumberAsString.substring(0,indexOfSecondNumber)) && firstNumberAsString.substring(indexOfFirstNumber, 3+ indexOfFirstNumber).equals(secondNumberAsString.substring(indexOfSecondNumber, 3+ indexOfSecondNumber))) {
            System.out.println("They are the same up to 2 decimal places.");
        } else {
            System.out.println("They are not the same up to 2 decimal places.");
        }
    }
}
