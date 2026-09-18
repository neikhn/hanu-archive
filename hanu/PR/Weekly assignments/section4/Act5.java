package section4;
import java.util.Scanner;
public class Act5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input your number: ");
        int input = sc.nextInt();
        sc.close();
        double output = Math.log(input) / Math.log(2);
        if (output == (int) (output)) {
            System.out.println(input + " is power of two.");
        } else {
            System.out.println(input + " is not power of two.");
        }
    }
}
