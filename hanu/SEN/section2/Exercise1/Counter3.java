package section2.Exercise1;

/**
 * A subtype of the Counter class that introduces additional operations for specifying initial value and incrementing by a specified amount.
 */
public class Counter3 extends Counter {

    /**
     * Creates a new Counter3 with the specified initial value.
     * @param n The initial value for the counter.
     * @effects Initializes this Counter3 with the specified initial value.
     */
    public Counter3(int n) {
        super(); // Call the Counter class constructor to initialize the value
        
        incr(n);      // Increment the value by n to achieve the desired initial value
    }

    /**
     * Increments the value of this Counter3 by the specified amount, if the amount is greater than 0.
     * @param n The amount to increment the counter by.
     * @modifies this
     * @effects If n > 0, increases the value of this Counter3 by n.
     */
    public void incr(int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                super.incr();
            }
        }
    }
}
