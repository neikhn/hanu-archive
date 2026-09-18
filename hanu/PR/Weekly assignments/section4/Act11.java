package section4;
import java.util.Scanner;
public class Act11 {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.print("Input the number of rows for first half of the triangle: ");
        int rows = user.nextInt();
        int doubleRows = rows * 2;
        user.close();
        for (int i = 1; i <= doubleRows - 1; i += 25) {
            for(int j = 1; j <= i; j ++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = doubleRows -3 ; i >= 1; i -= 2) {
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    } 
}
