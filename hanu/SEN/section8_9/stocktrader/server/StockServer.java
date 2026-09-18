package server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class StockServer {
    //all class attributes
    private static List<User> users = new ArrayList<>(); // store user accounts
    private List<Stock> stocks = new ArrayList<>(); //store stock information
    private List<StockInformation> userStocks = new ArrayList<>();
    private List<StockInformation> userHistory = new ArrayList<>();
    private Double userMoney;
    private boolean isLoggedIn = false;
    private LocalDate currentDate;
    private String userName;
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
    DecimalFormat dfDouble = new DecimalFormat("#,###.00"); // Format for double values
    DecimalFormat dfInt = new DecimalFormat("#,###"); // Format for integer values

    public StockServer() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Double getUserMoney() {
        return this.userMoney;
    }
    
    public String formatNumber(double number) {
        DecimalFormat df = new DecimalFormat("##,###.00");
        return df.format(number);
    }
    
    public boolean loadUsers(String fileName) {
        System.out.print("Loading all users...");
        users = new ArrayList<>(); // isolate, reinitiallize the users list
        
        try (Scanner sc = new Scanner(new File("File_structure_example\\" + fileName + ".txt"))) {
            while (sc.hasNextLine()) {
                User user = new User(sc.next(), sc.next());
                users.add(user);
            }
            System.out.println(" finished!");
            return true;
        } catch (FileNotFoundException e) {
        }
        
        return false;
    }
    
    public boolean loadStocks(String fileName) {
        Integer count = 1;
        System.out.print("Loading all available stocks on market...");
        
        stocks = new ArrayList<>(); // isolate, reinitiallize the stocks list
        
        try (Scanner sc = new Scanner(new File("File_structure_example\\" + fileName + ".txt"))) {
            while (sc.hasNextLine()) {
                Stock stock = new Stock(count, sc.next(), sc.nextDouble(), sc.nextInt());
                stocks.add(stock);
                count++;
            }
            System.out.println(" finished!");
            return true;
        } catch (FileNotFoundException e) {
        }
        
        return false;
    }
    
    private boolean loadUsersStock(String userName) {
        System.out.print("Loading user stocks...");
        userStocks = new ArrayList<>(); // isolate, reinitiallize the user's stocks list

        // load @userMoney
        try (Scanner sc = new Scanner(new File("File_structure_example\\" + userName + ".txt"))) {
            sc.next();// skip "Money" in the file
            userMoney = sc.nextDouble();
        } catch (FileNotFoundException e) {
        }
        // load @userStocks from history.txt file
        try (Scanner sc = new Scanner(new File("File_structure_example\\" + userName + "_history.txt"))) {
            Integer count = 0;
            while (sc.hasNextLine()) {
                // loading @commandType of StockInformation
                Integer commandType;
                if (sc.next().equalsIgnoreCase("buy")) {
                    commandType = 1;
                } else {
                    commandType = 0;
                }
                // loading stock
                Stock stock = new Stock(++count, sc.next(), sc.nextDouble(), sc.nextInt());
                // loading date
                LocalDate date = LocalDate.parse(sc.next(), formatter);
                // load whole 
                userStocks.add(new StockInformation(commandType, stock, date));
            }
            System.out.println(" finished!");
            return true;
        } catch (FileNotFoundException e) {
        }

        return false;
    }
        
    public boolean storeInformation() {
        // update userName.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("File_structure_example\\" + userName + ".txt"))) {
            // Write user's money to the file
            writer.write("Money " + dfDouble.format(userMoney));
            writer.newLine();

            // Write stock details based on listOwnStocks
            for (StockInformation stockInfo : userStocks) {
                Stock stock = stockInfo.getStock();
                int quantity = stock.getQuantity();
                double price = stock.getPrice();

                // Format and write stock details
                writer.write(stock.getName() + " " + price + " " + quantity);
                writer.newLine();
            }

            System.out.println("User's money updated.");
        } catch (IOException e) {
            System.err.println("Error writing user information to file.");
            return false;
        }
        // update history.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("File_structure_example\\" + userName + "history.txt"))) {
            // Write stock details based on listOwnStocks
            for (StockInformation stockInfo : userStocks) {
                Integer commandType = stockInfo.getCommandType();
                if (commandType == 1) {
                    writer.write("buy ");
                } else if (commandType == 0) {
                    writer.write("sell ");
                }
                LocalDate date = stockInfo.getPurchaseDate();
                Stock stock = stockInfo.getStock();
                double price = stock.getPrice();
                int quantity = stock.getQuantity();
                // Format and write stock details
                writer.write(stock.getName() + " " + quantity + " " + price + " " + date);
                writer.newLine();
            }

            System.out.println("User stocks has been stored.");
            return true;
        } catch (IOException e) {
            System.err.println("Error writing user information to file.");
            return false;
        }
    }

    public class AccessDeniedException extends Exception {
        public AccessDeniedException() { 
            super("Access Denied!");
        }
        
        public AccessDeniedException(String message) {
            super(message);
        }
    }
    
    public boolean login(String username, String password) throws AccessDeniedException {
        for (User user : users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                System.out.println("Welcome back, " + username + "!");
                isLoggedIn = true;
                loadUsersStock(username);
                return true;
            }
        }
        throw new AccessDeniedException();
    }
    
    
    public String listAllStocks() {
        StringBuilder stockTable = new StringBuilder();
        
        // Table header
        stockTable.append("+--------------------------------------------------+\n");

        stockTable.append(
        String.format("| %-9s | %-10s | %-11s | %-9s |\n", "Stock No.", "Stock Name", "Price(vnd)",
        "Quantity"));
        stockTable.append("|-----------|------------|-------------|-----------|\n");
        
        for (Stock stock : stocks) {
            // Use dfDouble for formatting double values (price)
            // Use dfInt for formatting integer values (quantity)
            stockTable.append(String.format("| %-9d | %-10s | %-11s | %-9s |\n",
            stock.getNumber(), stock.getName(), dfDouble.format(stock.getPrice()),
            dfInt.format(stock.getQuantity())));
        }
        stockTable.append("+--------------------------------------------------+");
        return stockTable.toString();
    }
    
    public String listOwnStocks() {
        StringBuilder stockTable = new StringBuilder();
    
        // Table header
        stockTable.append("+--------------------------------------------------+\n");

        stockTable.append(
                String.format("| %-9s | %-10s | %-11s | %-9s |\n", "Stock No.", "Stock Name", "Price(vnd)", "Quantity"));
        stockTable.append("|-----------|------------|-------------|-----------|\n");
    
        // loading user stocks
        for (StockInformation stockInfo : userStocks) {
            Stock stock = stockInfo.getStock();
            int stockNo = stock.getNumber();
    
            // Find the stock's price from the 'stocks' list based on its stock number
            double stockPrice = 0.0; // Default price if not found
            for (Stock marketStock : stocks) {
                if (marketStock.getName().equalsIgnoreCase(stock.getName())) {
                    stockPrice = marketStock.getPrice();
                    break; // Stop searching once the matching stock is found
                }
            }
    
            // Use dfDouble for formatting double values (price)
            // Use dfInt for formatting integer values (quantity)
            stockTable.append(String.format("| %-9d | %-10s | %-11s | %-9s |\n",
                    stockNo, stock.getName(), dfDouble.format(stockPrice), dfInt.format(stock.getQuantity())));
        }
        stockTable.append("+--------------------------------------------------+");

        return stockTable.toString();
    }
    
    
    public boolean purchase(int stockNo, int quantity) {
        for (Stock stock : stocks) {
            if (stockNo == stock.getNumber() && quantity <= stock.getQuantity() && quantity > 0) {
                double totalCost = stock.getPrice() * quantity;
                // Check if the market have enough stock
                if (stock.getQuantity() > quantity) {
                    stock.setQuantity(stock.getQuantity() - quantity);
                } else {
                    System.out.println("The market does not have enough stock.");
                    return false;
                }
                // Check if the user has enough money to make a purchase
                if (totalCost <= userMoney) {
                    double tempMoney = userMoney;
                    userMoney -= totalCost; // Deduct the cost from the user's money
                    // Transfering the purchased stock to @userStocks
                    boolean hasStock = false;
                    for (StockInformation stockInformation : userStocks) {
                        Stock currentStock = stockInformation.getStock(); //assign to the stock of userStocks
                        if (stock.getName().equalsIgnoreCase(currentStock.getName())) {
                            currentStock.setQuantity(currentStock.getQuantity() + quantity);
                            hasStock = true;
                        }
                    }
                    if (!hasStock) {
                        Stock pending = new Stock(userStocks.size() + 1, stock.getName(), stock.getPrice(), quantity);
                        userStocks.add(new StockInformation(1, pending, currentDate));
                    }
                    System.out.println(
                            "Successfully purchased " + quantity + " shares of " + stock.getName());
                    System.out.println("Your balance has been decreased from: " + formatNumber(tempMoney) + " to "
                            + formatNumber(userMoney));
                    return true;
                } else {
                    System.out.println("Insufficient funds to make this purchase.");
                    return false;
                }
            }
        }
        System.out.println("Invalid stock number or quantity.");
        return false;
    }
    
    public boolean sellStock(int stockNo, int quantity) {
        // iterating through all stock of @userStocks
        for (StockInformation stockInformation : userStocks) {
            // selecting stock based on stockNumber
            Stock currentStock = stockInformation.getStock(); //assign to the stock of userStocks
            if (stockNo == currentStock.getNumber()) {
                // comparing sell quantity vs owned quantity
                if (currentStock.getQuantity() >= quantity) {
                    currentStock.setQuantity(currentStock.getQuantity() - quantity);
                    // getting price of sold stock from market
                    for (Stock stock : stocks) {
                        if (stockNo == stock.getNumber()) {
                            Double tempMoney = userMoney;
                            userMoney += (stock.getPrice() * quantity); // increase @userMoney
                            stock.setQuantity(stock.getQuantity() + quantity); // increase market's stock
                            System.out.println(
                                    "Successfully sold " + formatNumber(quantity) + " shares of "
                                            + stock.getName());
                            System.out
                                    .println("Your balance has been increased from: " + formatNumber(tempMoney) + " to "
                                            + formatNumber(userMoney));
                            // storeInformation(stockInformation);
                            return true;
                        }

                    }
                } else {
                    System.out.println("Insufficient quantity to make this sell.");
                    return false;
                }
            }
        }
        return false;
    }
    
    public void nextDay() {
        Random random = new Random();
        double maxChangePercent = 0.25; // 25%

        for (Stock stock : stocks) {
            double originalPrice = stock.getPrice();
            double priceChange = originalPrice * (2 * random.nextDouble() - 1) * maxChangePercent;
            double newPrice = originalPrice + priceChange;

            // Ensure the new price is not negative
            if (newPrice < 0) {
                newPrice = 0;
            }

            stock.setPrice(newPrice);
        }

        System.out.println("A new day has passed. Stock prices have been updated.");
    }

    public Double checkBalance() {
        double accountBalance = userMoney;

        for (StockInformation stockInfo : userStocks) {
            Stock stock = stockInfo.getStock();
            int quantity = stock.getQuantity();
            double price = stock.getPrice();

            // Calculate the value of the user's stocks for this stock
            double stockValue = price * quantity;

            // Add the stock value to the account balance
            accountBalance += stockValue;
        }
        return accountBalance;
    }
    
}