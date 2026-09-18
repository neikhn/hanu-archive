package section8;

import java.util.*;

public class Act2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array length: ");
        int arrayLength = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arrayLength; i++) {
            Integer elements = sc.nextInt();
            list.add(elements);
        }
        System.out.println(list);
        sc.close();
        shiftRight(arrayLength, list);
    }
    
    public static void shiftRight(int arrayLength, ArrayList<Integer> list) {
        int temp = list.get(arrayLength - 1);
        //save last element with a temporary variable, remove last element, add temporary variable to index 0
        list.remove(arrayLength - 1);
        list.add(0, temp);
        System.out.println(list);
    }
}
