package server;

import java.time.LocalDate;

public class StockInformation {
    Integer commandType; //store 1 as the equivilent of buy and 0 for sell
    Stock stock;
    LocalDate purchaseDate;


    public StockInformation() {
    }

    public StockInformation(Integer commandType, Stock stock, LocalDate purchaseDate) {
        this.commandType = commandType;
        this.stock = stock;
        this.purchaseDate = purchaseDate;
    }

    // getters and setters
    public Integer getCommandType() {
        return this.commandType;
    }

    public void setCommandType(Integer commandType) {
        this.commandType = commandType;
    }

    public Stock getStock() {
        return this.stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public LocalDate getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
}
