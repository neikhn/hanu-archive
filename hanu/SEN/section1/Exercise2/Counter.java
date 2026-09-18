package section1.Exercise2;

/**
 * A Counter class that represents a simple counter for counting footstep or similar events.
 * Counter objects maintain a non-negative integer value.
 */
public class Counter {
    private int value;  // The value of the counter

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

    /**
     * Main function to test the Counter class.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Counter counter = new Counter();
        
        System.out.println("Initial value: " + counter.get());

        // Increment the counter a few times
        counter.incr();
        counter.incr();
        counter.incr();
        
        System.out.println("Value after incrementing: " + counter.get());
    }
}

