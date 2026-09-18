package section6;
import java.util.Scanner;
public class Act1 {
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter A: ");
        int a = sc.nextInt();
        System.out.print("Enter B: ");
        int b = sc.nextInt();
        sc.close();
        calculate(a, b);
    }
    //function tinh GCD
    static void calculate(int a, int b) {
        int temp, tempBig, tempSmall;
        tempBig = (a > b) ? a : b;
        tempSmall = (a > b) ? b : a;
        if (a == 0 || b == 0) {
            result = tempBig;
        }
        while (tempBig != 0 && tempSmall != 0) {
            temp = tempSmall;
            result = temp;
            tempSmall = tempBig % tempSmall;
            tempBig = temp;
        }
        System.out.println("GCD(" + a + ", " + b + ") = " + result);
    }
}
