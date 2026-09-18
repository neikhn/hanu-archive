package section4.Exercise5;

public class Init {
    public static void main(String[] args) {
        IntegerLinkedList linkedList = new IntegerLinkedList();

        for (int i = 0; i < 50; i++) {
            linkedList.add(i);
        }
        
        linkedList.evenIterator();
    }
}
