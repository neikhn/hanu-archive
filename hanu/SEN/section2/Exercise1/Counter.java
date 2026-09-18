package section2.Exercise1;

/**
 * a Counter class that represents a simple counter for counting footstep or similar events.
 * Counter objects maintain a non-negative integer value.
 */
public class Counter {
    private int value;
    
    /**
     * Creates a new Counter with an initial value of 0.
     * @effects Initializes this Counter with a value of 0.
     */
    public Counter() {
        value = 0;
    }

    /**
     * Returns the current value of this Counter.
     * @return The value of this Counter.
     * @effects Does not modify this Counter.
     */
    public int get() {
        return value;
    }

    /**
     * Increments the value of this Counter by 1.
     * @modifies this
     * @effects Increases the value of this Counter by 1.
     */
    public void incr() {
        value++;
    }
}

