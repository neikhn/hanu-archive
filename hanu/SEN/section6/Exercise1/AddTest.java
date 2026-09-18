package section6.Exercise1;

import static org.junit.Assert.*;
import org.junit.Test;

public class AddTest {

    @Test
    public void testCountNegative() {
        // Test case 1: Empty array
        int[] a1 = {};
        assertEquals(0, Arrays.countNegative(a1));

        // Test case 2: Array with one negative element
        int[] a2 = {-3};
        assertEquals(1, Arrays.countNegative(a2));
        

        // Test case 3: Array with all positive elements
        int[] a3 = {1, 2, 3};
        assertEquals(0, Arrays.countNegative(a3));

        // Test case 4: Array with mixed positive and negative elements
        int[] a4 = {-1, 2, -3, 4, -5};
        assertEquals(3, Arrays.countNegative(a4));
    }

    @Test
    public void testMin() {
        // Test case 1: Array with one element
        int[] a1 = {5};
        assertEquals(5, Arrays.min(a1));

        // Test case 2: Array with all positive elements
        int[] a2 = {2, 4, 6};
        assertEquals(2, Arrays.min(a2));

        // Test case 3: Array with all negative elements
        int[] a3 = {-5, -2, -8};
        assertEquals(-8, Arrays.min(a3));

        // Test case 4: Array with mixed positive and negative elements
        int[] a4 = {-1, 2, -3, 4, -5};
        assertEquals(-5, Arrays.min(a4));
    }

    @Test
    public void testIsAscSorted() {
        // Test case 1: Ascending sorted array
        int[] a1 = {1, 2, 3, 4, 5};
        assertTrue(Arrays.isAscSorted(a1));

        // Test case 2: Descending sorted array
        int[] a2 = {5, 4, 3, 2, 1};
        assertFalse(Arrays.isAscSorted(a2));

        // Test case 3: Array with equal elements
        int[] a3 = {3, 3, 3, 3, 3};
        assertTrue(Arrays.isAscSorted(a3));

        // Test case 4: Array with mixed order
        int[] a4 = {1, 3, 2, 4, 5};
        assertFalse(Arrays.isAscSorted(a4));
    }

    @Test
    public void testLength() {
        // Test case 1: Array with no null character
        char[] a1 = {'h', 'e', 'l', 'l', 'o'};
        assertEquals(5, Arrays.length(a1));

        // Test case 2: Array with null character in the middle
        char[] a2 = {'h', 'e', 'l', '\u0000', 'o'};
        assertEquals(3, Arrays.length(a2));

        // Test case 3: Array with null character at the end
        char[] a3 = {'h', 'e', 'l', 'l', 'o', '\u0000'};
        assertEquals(5, Arrays.length(a3));

        // Test case 4: Empty array
        char[] a4 = {};
        assertEquals(0, Arrays.length(a4));
    }

    @Test
    public void testMedian() {
        // Test case 1: Array with one element
        double[] a1 = {5.0};
        assertEquals(5.0, Arrays.median(a1), 0.001);

        // Test case 2: Array with odd number of elements
        double[] a2 = {1.0, 3.0, 2.0};
        assertEquals(2.0, Arrays.median(a2), 0.001);

        // Test case 3: Array with even number of elements
        double[] a3 = {4.0, 1.0, 3.0, 2.0};
        assertEquals(2.5, Arrays.median(a3), 0.001);

        // Test case 4: Array with negative values
        double[] a4 = {-5.0, -1.0, -3.0, -2.0};
        assertEquals(-2.5, Arrays.median(a4), 0.001);
    }

    @Test
    public void testCompare() {
        // Test case 1: Arrays are disjoint
        double[] a1 = {1.0, 2.0, 3.0};
        double[] b1 = {4.0, 5.0, 6.0};
        assertEquals(-2, Arrays.compare(a1, b1));

        // Test case 2: Array a is a subset of b
        double[] a2 = {1.0, 2.0};
        double[] b2 = {1.0, 2.0, 3.0, 4.0};
        assertEquals(-1, Arrays.compare(a2, b2));

        // Test case 3: Arrays are equal
        double[] a3 = {1.0, 2.0, 3.0};
        double[] b3 = {1.0, 2.0, 3.0};
        assertEquals(0, Arrays.compare(a3, b3));

        // Test case 4: Array a is a superset of b
        double[] a4 = {1.0, 2.0, 3.0, 4.0};
        double[] b4 = {1.0, 2.0};
        assertEquals(1, Arrays.compare(a4, b4));
    }
}