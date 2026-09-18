package section4.Exercise6;

public class Init {
    public static void main(String[] args) {
        PrimeLinkedList linkedList = new PrimeLinkedList();

        for (int i = 0; i < 50; i++) {
            linkedList.add(i);
        }
        
        linkedList.primeIterator();
    }
}
