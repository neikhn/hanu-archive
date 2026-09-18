package section5;
import java.util.Scanner;
public class Act4Review {
    public static void main(String[] args) {
        System.out.println("Input rows: ");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        sc.close();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows; j++) {
                System.out.print("* ");
            }

            System.out.print("  ");

            for (int k = rows + 1; k <= rows * 2; k++) {
                if (i == 1 || i == rows || k == rows + 1 || k == rows * 2) {
                    System.out.print("* ");
                    // System.out.print(" ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
