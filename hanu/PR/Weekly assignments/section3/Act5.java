package section3;
import java.util.Scanner;

public class Act5 {
    public static void powerOfTwo(int x) {
            double n = (Math.log(x) / Math.log(2));
            if (n == (int) n) {
                System.out.println(x + " is the power of 2.");
            } else {
                System.out.println(x + " is not the power of 2.");
            }
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number to check whether it is the power of 2: ");
        int x = sc.nextInt();
        sc.close();
        powerOfTwo(x);
    }
}
