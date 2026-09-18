package server;

public class Stock {
    String name;
    Double price;
    Integer quantity;
    Integer number; // temporary way of ordering stocks

    public Stock() {
    }

    public Stock(Integer number, String name, Double price, Integer quantity) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Stock(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    // getters and setters

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
