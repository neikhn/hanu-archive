package section2.Exercise1;

/**
 * FOR THE QUESTION OF: "Is Counter2 a legitimate subtype of Counter?"
 *      Counter2 is not a legitimate subtype of Counter, as it violates the Liskov Substitution Principle
 * 
 *      The Liskov Substitution Principle (LSP) states that objects of a derived class (subtype) should be
 *          substitutable for objects of the base class (supertype) without affecting the correctness of the program.
 * 
 *      In the Counter class, the incr() operation increments the counter value by 1.
 *      In the Counter2 class, the overridden incr() operation increments the counter value by 2 (calling super.incr() twice).
 * 
 *      This change in behavior means that substituting a Counter2 object for a Counter object will lead to different outcomes 
 *          when calling the incr() operation. This violates the Liskov Substitution Principle, as the derived class (Counter2) 
 *          alters the expected behavior of the base class (Counter).
 * 
 *      The Counter2 class should maintain the behavior of the Counter class's operations while potentially adding new behavior
 */
public class InitExercise1 extends Counter2 {
    /**
     * main fuction for testing Counter2
     * @param args
     */
    public static void main(String[] args) {
        Counter counter = new Counter();
        Counter2 counter2 = new Counter2();
       
        // superclass
        System.out.println("superclass Counter:");
        System.out.println("Initial value: " + counter.get());

        // Increment the counter a few times
        counter.incr();
        counter.incr();
        counter.incr();
        
        System.out.println("Value after incrementing: " + counter.get());

        // subclass Counter2
        System.out.println("\nsubclass Counter2:");
        System.out.println("Initial value: " + counter2.get());

        // Double the counter's value a few times
        counter2.incr();
        counter2.incr();
        counter2.incr();
        
        System.out.println("Value after doubling: " + counter2.get());
    }
}
