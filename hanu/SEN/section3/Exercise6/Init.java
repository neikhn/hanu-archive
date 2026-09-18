package section3.Exercise6;

public class Init extends ArrayCalculator{
    public static void main(String[] args) {
        int[] arrayA = {10, 20, 30, 40, 50};
        int[] arrayB = {2, 5};

        try {
            divide(arrayA, arrayB);
        } catch (CustomIndexOutOfBoundsException | CustomArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
