package section2.Exercise4;
public class Vehicle {
    private String name;
    private double width;
    private double height;
    private double length;
    private double weight;
    private int seatingCapacity;
    private String registrationNumber;
    private int registrationNumberLength = 12;
    
    public Vehicle(String name, double width, double height,
                   double length, double weight, int seatingCapacity,
            String registrationNumber) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.seatingCapacity = seatingCapacity;
        this.registrationNumber = validregistrationNumber(registrationNumber, registrationNumberLength);
    }

//getters and setters for attributes
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSeatingCapacity() {
        return this.seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public static String validregistrationNumber(String registrationNumber,
            int registrationNumberLength) {
        if (registrationNumber.length() <= registrationNumberLength) {
            return registrationNumber;
        } else
            throw new IllegalArgumentException("The registration number length must not exceeds " +
                    registrationNumberLength + " alpha-numerical characters.");
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [name=" + name + ", width=" + width + ", heigh=" + height +
                ", weight=" + weight + ", length=" + length + ", seatingCapacity=" + seatingCapacity +
                ", registrationNumber=" + registrationNumber + "]";
    }
    
    public void travel(String begining, String destination, int passengerAmount) {
        System.out.println("[ Vehicle: " + this.getClass().getSimpleName() + 
                            " | " + "\u25B2" + "Starting from: " + begining + ", " + "\u25BC" + "Location: " + destination +
                            " | " + "\uD83D\uDC63" + "Number of passenger(s): " + passengerAmount + " ]");
    }
}
