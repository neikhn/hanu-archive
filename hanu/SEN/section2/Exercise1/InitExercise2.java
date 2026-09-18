package section2.Exercise1;

/**
 * FOR THE QUESTION OF: "Is Counter3 a legitimate subtype of Counter?"
 *      Counter3 is a legitimate subtype of Counter
 * 
 *      Counter3 introduces new features while maintaining the behavior of the Counter class. 
 *          The operations added in Counter3 (Counter3(int n) and incr(int n)) extend the capabilities of 
 *          the original Counter class without altering its core functionality.
 */
public class InitExercise2 extends Counter3 {
    public InitExercise2(int n) {
        super(n);
    }

    /**
     * Main function to test the Counter3 class.
     */
    public static void main(String[] args) {
        Counter counter = new Counter();
        Counter3 counter3 = new Counter3(5);
        
        // superclass
        System.out.println("superclass Counter:");
        System.out.println("Initial value: " + counter.get());

        // Increment the counter a few times
        counter.incr();
        counter.incr();
        counter.incr();
        
        System.out.println("Value after incrementing: " + counter.get());

        // subclass Counter3
        System.out.println("\nsubclass Counter3:");
        System.out.println("Initial value: " + counter3.get());

        // Increment the counter by a specified amount
        counter3.incr(3);
        
        System.out.println("Value after incrementing by 3: " + counter3.get());
    }
}
