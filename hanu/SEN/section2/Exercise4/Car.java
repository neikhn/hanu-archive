package section2.Exercise4;

public class Car extends Vehicle {
    
    private static int registrationNumberLength = 6;

    public Car(String name, double width, double height,
               double length, double weight, int seatingCapacity,
               String registrationNumber) {
        super(name, width, height,
              validateLength(length), validateWeight(weight), seatingCapacity,
              validregistrationNumber(registrationNumber, registrationNumberLength));
    }

    private static double validateWeight(double weight) {
        if (weight >= 1000.0 && weight <= 2000.0) {
            return weight;
        } else {
            throw new IllegalArgumentException("Car weight must in the range [1000.0, 2000.0] (kgs)");
        }
    }

    private static double validateLength(double length) {
        if (length >= 1.5 && length <= 3.5) {
            return length;
        } else {
            throw new IllegalArgumentException("Car length must in the range [1.5, 3.5] (meters)");
        }
    }
}
