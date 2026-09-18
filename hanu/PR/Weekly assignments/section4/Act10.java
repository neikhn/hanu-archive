package section4;
import java.util.Scanner;
public class Act10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        int input = sc.nextInt();
        sc.close();
        int temp = 1;
        for (int i = 1; i <= input; i++) {
            temp = temp * i;
        }
        System.out.print(temp);
    }
}
