package section8;

import java.util.*;

public class Act1 {
    public static void main(String[] args) {
        countLastDigits();
    }
    
    public static void countLastDigits() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the amount of digits: ");
        int arrayLength = sc.nextInt();
        ArrayList<Integer> digits = new ArrayList<Integer>();
        int[] out = new int[10];
        for (int i = 0; i < arrayLength; i++) {
            digits.add(sc.nextInt());
            out[digits.get(i) % 10]++;
            //extract last digits 
        }
        System.out.println(Arrays.toString(out));
        sc.close();
    }
}
