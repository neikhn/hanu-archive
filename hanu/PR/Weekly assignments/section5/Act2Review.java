package section5;
import java.util.Scanner;
public class Act2Review {
    //calling out each functions
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount of integer inputs: ");
        int size = sc.nextInt();
        long[] box = new long[size];
        long input;
        for (int i = 0; i < size; i ++) {
            System.out.print("Enter integer number " + (i + 1) + ": ");
            input = sc.nextLong();
            box[i] = input;
        }
        sc.close();
        smallestLargest(box, size);
        evenOdd(box, size);
        cumulative(box, size);
    }
    //function extracting the smallest and largest input(s)
    public static void smallestLargest(long[] box, int size) {
        long smallest = box[0]; long largest = box[0];
        for (int i = 0; i < size; i ++) {
            if (smallest > box[i]) {
                smallest = box[i];
            }
        }
        for (int i = 0; i < size; i ++) {
            if (largest < box[i]) {
                largest = box[i];
            }
        }
        System.out.println("The SMALLEST input is: " + smallest);
        System.out.println("The LARGEST input is: " + largest);
    }
    //function extracting even and odd input(s)
    public static void evenOdd(long[] box, int size) {
        int odd = 0; int even = 0;
        System.out.print("Odd input(s) extracted: ");
        for (int i = 0; i < size; i ++) {
            if (box[i] % 2 != 0) {
                odd ++;
                System.out.print(box[i] + " ");
            }
        }
        System.out.println();
        System.out.print("Even input(s) extracted: ");
        for (int i = 0; i < size; i ++) {
            if (box[i] % 2 == 0) {
                even ++;
                System.out.print(box[i] + " ");
            }
        }
        System.out.println("\nThe number of ODD inputs: " + odd);
        System.out.println("The number of EVEN inputs: " + even);
    }
    //functing calculating cumulative totals from input(s)
    public static void cumulative(long[] box, int size) {
        System.out.print("Input overview: ");
        for (int i = 0; i < size; i ++) {
            System.out.print(box[i] + " ");
        } 
        System.out.print("\nCUMULATIVE TOTALS: ");  
        int currentSum = 0;
        for (int i = 0; i < size; i ++) {
            currentSum += box[i];
            System.out.print((currentSum) + " ");
        }
    }
}
