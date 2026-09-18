package section5.Exercise1;

/**
 * @overview
 *           Represents a collection of utility procedures that are commonly
 *           used in applications.
 * 
 * @author dmle
 */
public class Toolkit {

    /**
     * @Overview: count the addition of x and y
     * @effects
     *          return the arithmetic sum of x, y;
     *          i.e. result = x + y.
     */

    /**
     * Test case 1 (Typical):
     * x = 5, y = 7
     * Expected output: result = 12
     * Explanation: typical positive values
     *
     * Test case 2 (Typical):
     * x = -3, y = -4
     * Expected output: result = -7
     * Explanation: typical negative values
     *
     * Test case 3 (Atypical):
     * x = 0, y = 0
     * Expected output: result = 0
     * Explanation: both values at the lower bound.
     *
     * Test case 4 (Atypical):
     * x = Integer.MAX_VALUE, y = Integer.MAX_VALUE
     * Expected output: result = -2
     * Explanation: both values at the upper bound. Overflow -> negative value
     *
     * Test case 5 (Atypical):
     * x = Integer.MIN_VALUE, y = Integer.MIN_VALUE
     * Expected output: result = 0
     * Explanation: both values at the lower bound
     */

    public static int add(int x, int y) {
        return x + y;
    }

    /**
     * @Overview: find the remainder of x in its division by y
     * @effects
     *          return the remainder of x in its division by y;
     *          i.e. result = x - (((int) x/y) * y).
     */

    /**
     * Test case 1:
     * x = 10
     * y = 3
     * Expected output: remainder = 1
     * Explanation: The remainder of 10 divided by 3 is 1.
     *
     * Test case 2:
     * x = 20
     * y = 5
     * Expected output: remainder = 0
     * Explanation: The remainder of 20 divided by 5 is 0.
     *
     * Test case 4:
     * x = -8
     * y = 3
     * Expected output: remainder = -2
     * Explanation: The remainder of -8 divided by 3 is -2.
     */
    public static int remainder(int x, int y) {
        return x % y;
    }

    /**
     * @Overview: find the larger of a and b
     * @effects
     *          return the larger of a and b (result is the argument closer to
     *          positive infinity);
     * 
     *          <pre>
     *    i.e.  
     *    if a = b 
     *      result = a
     *    else if a = NaN OR b = NaN
     *      result = NaN 
     *    else if {a,b} = {0+,0-} (one is positive zero and the other negative zero), 
     *      result = 0+ (note: negative zero < positive zero)
     *    else if a > b
     *      result = a
     *    else 
     *      result = b
     *          </pre>
     */

    /**
     * Test case 1 (Typical):
     * a = 5.0
     * b = 7.0
     * Expected output: result = 7.0
     * Explanation: positive values, b larger.
     *
     * Test case 2 (Typical):
     * a = -3.5
     * b = -2.0
     * Expected output: result = -2.0
     * Explanation: negative values, a larger.
     *
     * Test case 3 (Typical):
     * a = 0.0
     * b = -0.0
     * Expected output: result = 0.0
     * Explanation: both values are zero, with one being positive zero and the other
     * negative zero.
     *
     * Test case 4 (Atypical):
     * a = NaN
     * b = 4.2
     * Expected output: result = NaN
     * Explanation: one value is NaN, which should result in NaN.
     *
     * Test case 5 (Atypical):
     * a = Double.POSITIVE_INFINITY
     * b = Double.NEGATIVE_INFINITY
     * Expected output: result = Double.POSITIVE_INFINITY
     * Explanation: One value is positive infinity, other is negative
     * infinity, resulting in positive infinity being the larger value.
     */
    public static double max(double x, double y) {
        return Math.max(x, y);
    }

    /**
     * @Overview: calculate the sum of all elements in list a. if array is null or
     *            empty, return -1
     * @effects
     *          if a is null or empty
     *          return -1
     *          else
     *          return the arithmetic sum of the elements of a
     */

    /**
     * Test case 1 (Typical):
     * a = [1, 2, 3, 4, 5]
     * Expected output: sum = 15
     * Explanation: case with positive values.
     *
     * Test case 2 (Typical):
     * a = [-1, -2, -3, -4, -5]
     * Expected output: sum = -15
     * Explanation: case with negative values.
     *
     * Test case 3 (Typical):
     * a = [0, 0, 0, 0, 0]
     * Expected output: sum = 0
     * Explanation: case with all elements being zero.
     *
     * Test case 4 (Atypical):
     * a = null
     * Expected output: sum = -1
     * Explanation: array is null, which should result in -1.
     *
     * Test case 5 (Atypical):
     * a = []
     * Expected output: sum = -1
     * Explanation: array is empty, which should result in -1.
     *
     * Test case 6 (Atypical):
     * a = [Integer.MAX_VALUE, -Integer.MIN_VALUE]
     * Expected output: sum = -1
     * Explanation: overflows, cannot be represented, resulting in -1.
     */
    public static long sum(int[] a) {
        long s = 0;
        for (int x : a) {
            s += x;
        }

        return s;
    }

    /**
     * @Overview: find the product of all the elements in a. If a is null or empty,
     *            return -1
     * @effects
     *          if a is null or empty
     *          return -1
     *          else if exists x in a s.t x = 0
     *          return 0
     *          else
     *          return the product of the elements of a
     */

    /**
     * Test case 1 (Typical):
     * a = [1, 2, 3, 4, 5]
     * Expected output: product = 120
     * Explanation: case with positive values.
     *
     * Test case 2 (Typical):
     * a = [-1, -2, -3, -4, -5]
     * Expected output: product = -120
     * Explanation: case with negative values.
     *
     * Test case 3 (Typical):
     * a = [1, 2, 0, 4, 5]
     * Expected output: product = 0
     * Explanation: case with zero value in the array.
     *
     * Test case 4 (Atypical):
     * a = null
     * Expected output: product = -1
     * Explanation: array is null, which should result in -1.
     *
     * Test case 5 (Atypical):
     * a = []
     * Expected output: product = -1
     * Explanation: array is empty, which should result in -1.
     */
    public static long product(int[] a) {
        long p = 0;
        for (int x : a) {
            p *= x;
        }

        return p;
    }

    /**
     * @Overview: find the number of characters in s. if s is null, throw exception
     * @effects
     *          if s is null
     *          throws NullPointerException
     *          else if s is empty
     *          return 0
     *          else
     *          return the number of characters in s
     */

    /**
     * Test case 1 (Typical):
     * s = "Hello, World!"
     * Expected output: length = 13
     * Explanation: case with a non-null, non-empty string.
     *
     * Test case 2 (Atypical):
     * s = null
     * Expected output: NullPointerException is thrown
     * Explanation: the case when the input string is null.
     *
     * Test case 3 (Typical):
     * s = ""
     * Expected output: length = 0
     * Explanation: case with an empty string.
     *
     * Test case 4 (Typical):
     * s = "1234567890"
     * Expected output: length = 10
     * Explanation: case with a non-null, non-empty string of numeric
     * characters.
     *
     * Test case 5 (typical):
     * s = " "
     * Expected output: length = 7
     * Explanation: case with a non-null, non-empty string of spaces.
     */
    public static int lenString(String s) throws NullPointerException {
        if (s == null)
            throw new NullPointerException("Toolkit.lenString(null)");

        return s.length();
    }

    /**
     * @Overview: find substring of a String, from start position to end position.
     *            If input error, throw exception (string s is null or start point
     *            not in s or end point not in s or end point < start point)
     * 
     * 
     * @effects
     *          if s is null OR startPos * endPos < 0 OR startPos >= endPos OR
     *          endPos > length(s)
     *          throws IllegalArgumentException
     *          else
     *          returns a new string as a substring of s, which
     *          begins at the character at startPos and
     *          extends to the character at endPos - 1
     *          (thus, length(result) = endPos-startPos).
     * 
     *          <p>
     *          e.g.:
     * 
     *          <pre>
     *        subString("hamburger",4, 8) = "urge"
     *        subString("smiles",1, 5) returns "mile"
     *          </pre>
     */

    /**
     * Test case 1 (Typical):
     * s = "Hello, World!", startPos = 4, endPos = 8
     * Expected output: "o, W"
     * Explanation: Typical case with a non-null string and valid start and end
     * positions.
     *
     * Test case 2 (Atypical):
     * s = null, startPos = 1, endPos = 5
     * Expected output: IllegalArgumentException is thrown
     * Explanation: Testing the case when the input string is null.
     *
     * Test case 3 (Atypical):
     * s = "Hello, World!", startPos = -1, endPos = 5
     * Expected output: IllegalArgumentException is thrown
     * Explanation: Testing the case when the start position is negative.
     *
     * Test case 4 (Atypical):
     * s = "Hello, World!", startPos = 4, endPos = 20
     * Expected output: IllegalArgumentException is thrown
     * Explanation: Testing the case when the end position is greater than the
     * length of the string.
     *
     * Test case 5 (Atypical):
     * s = "Hello, World!", startPos = 8, endPos = 4
     * Expected output: IllegalArgumentException is thrown
     * Explanation: Testing the case when the start position is greater than or
     * equal to the end position.
     *
     * Test case 6 (Typical):
     * s = "abcdefg", startPos = 1, endPos = 6
     * Expected output: "bcdef"
     * Explanation: Typical case with a non-null string and valid start and end
     * positions.
     */

    public static String subString(String s, int startPos, int endPos) throws IllegalArgumentException {
        if (s == null || startPos * endPos < 0 || startPos >= endPos || endPos > s.length())
            throw new IllegalArgumentException(String.format("Toolkit.subString(%s, %d, %d)", s, startPos, endPos));

        return s.substring(startPos, endPos);
    }

    // self-testing
    public static void main(String[] args) {
        System.out.println(
                subString("smiles", 1, 5)
        // subString(null, 1,5)
        );
        // lenString(null);
    }
}
