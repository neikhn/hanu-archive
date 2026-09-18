package section2.Exercise1;

/**
 * A subtype of the Counter class that contains additional operations for doubling the value.
 */
public class Counter2 extends Counter {

    /**
     * Creates a new Counter2 with an initial value of 0.
     * @effects Initializes this Counter2 with a value of 0.
     */
    public Counter2() {
        // The constructor of Counter class will be implicitly called.
        // No need to explicitly set the value to 0 here.
    }

    /**
     * Doubles the value of this Counter2.
     * @modifies this
     * @effects Doubles the value of this Counter2.
     */
    @Override
    public void incr() {
        super.incr();  // Increment the value by 1 (from the Counter class)
        super.incr();  // Increment the value again (doubling the value)
    }
}

