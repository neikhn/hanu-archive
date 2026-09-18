package section1.Exercise3;

public class Bus extends Vehicle {

    private static int registrationNumberLength = 8;
    
    public Bus(String name, double width, double height,
               double length, double weight, int seatingCapacity,
               String registrationNumber) {
        super(name, width, height,
              validateLength(length), validateWeight(weight), seatingCapacity,
              validregistrationNumber(registrationNumber, registrationNumberLength));
    }

    private static double validateWeight(double weight) {
        if (weight >= 5000.0 && weight <= 20000.0) {
            return weight;
        } else {
            throw new IllegalArgumentException("Bus weight must in the range [5000.0, 20000.0] (kgs)");
        }
    }

    private static double validateLength(double length) {
        if (length >= 4.0 && length <= 10.0) {
            return length;
        } else {
            throw new IllegalArgumentException("Bus length must in the range [4.0, 10.0] (meters)");
        }
    }
}
