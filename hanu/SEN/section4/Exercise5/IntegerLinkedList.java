package section4.Exercise5;

import java.util.*;

public class IntegerLinkedList extends LinkedList<Integer> {
    
    public IntegerLinkedList() {
        super();
    }

    public void evenIterator() {
        System.out.print("[");
        
        for (Integer element : this) {
            if (element % 2 == 0) {
                System.out.printf(" %d ", element);
            }
        }
        System.out.print("]");
    }
}
