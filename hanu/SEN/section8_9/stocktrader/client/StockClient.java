package client;

import java.text.DecimalFormat;
import java.util.Scanner;
import server.StockServer;
import server.StockServer.AccessDeniedException;

public class StockClient {
    static DecimalFormat dfDouble = new DecimalFormat("#,###.00"); // Format for double values
    static DecimalFormat dfInt = new DecimalFormat("#,###"); // Format for integer values

    static String userName;
    public static void main(String[] args) {
        StockServer sv = new StockServer(); // Create an instance of StockServer
        Scanner sc = new Scanner(System.in);
        sv.loadUsers("userlist");
        sv.loadStocks("StockInfo");

        //  logging in
        System.out.print("Enter your account name: ");
        sv.setUserName(sc.nextLine()); 
        System.out.print("Enter your account password: ");
        String pass = sc.nextLine();
        try {
            sv.login(sv.getUserName(), pass);
        } catch (AccessDeniedException e) {
            System.err.println(e.getMessage());
        }
        
        menu(sv);
    }

    public static void menu(StockServer sv) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "+-------------------------+" + "\n" +
                    "|         OPTIONS         |" + "\n" +
                    "| [1] List Own Stocks     |" + "\n" +
                    "| [2] List All Stocks     |" + "\n" +
                    "| [3] Check Balance       |" + "\n" +
                    "| [4] Purchase Stock      |" + "\n" +
                    "| [5] Sell Stock          |" + "\n" +
                    "| [6] Next Day            |" + "\n" +
                    "| [7] Store Information   |" + "\n" +
                    "| [0] Exit                |" + "\n" +
                    "+-------------------------+") ;

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println(sv.listOwnStocks());    
                    break;
                case 2:
                    System.out.println(sv.listAllStocks());
                    break;
                case 3:
                    System.out.println(dfDouble.format(sv.checkBalance()) + "(vnd) (based on curret market value.)");
                    break;
                case 4:
                    System.out.print("Select stock No: ");
                    int buyNumber = scanner.nextInt();
                    System.out.print("Purchase amount: ");
                    int buyQuantity = scanner.nextInt();
                    sv.purchase(buyNumber, buyQuantity);
                    break;
                case 5:
                    System.out.print("Select stock No: ");
                    int sellNumber = scanner.nextInt();
                    System.out.print("Sell amount: ");
                    int sellQuantity = scanner.nextInt();
                    sv.sellStock(sellNumber, sellQuantity);
                    break;
                case 6:
                    sv.nextDay();    
                    break;
                case 7:
                    sv.storeInformation();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    // public static void main(String[] args) {
    //     StockServer sv = new StockServer();
        
        // sv.loadUsers("userlist");
        // sv.loadStocks("StockInfo");
        // System.out.println("Testing @login method");
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter your account name: ");
        // String name = sc.nextLine();
        // System.out.print("Enter your account password: ");
        // String passWord = sc.nextLine();
        // try {
        //     sv.login(name, passWord);
        // } catch (AccessDeniedException e) {
        //     System.err.println(e.getMessage());
        // }
        
        // System.out.println("Testing @listOwnStock method");
        // System.out.println(sv.listOwnStocks());

        // System.out.println("Testing @sellStock method");
        // System.out.print("Select stock No: ");
        // int numberSell = sc.nextInt();
        // System.out.print("Selling at an amount of: ");
        // int amountSell = sc.nextInt();
        // sv.sellStock(numberSell, amountSell);

        // System.out.println("Relisting with @listOwnStock method, the stocks' price are taken from the @stocks ArrayList");
        // System.out.println(sv.listOwnStocks());

        // System.out.println("Testing @listAllStocks method");
        // System.out.println(sv.listAllStocks());

        // System.out.println("Testing @purchase method");
        
        // System.out.print("Select stock No: ");
        // Integer numberBuy = sc.nextInt();
        // System.out.print("Purchasing at an amount of: ");
        // Integer amountBuy = sc.nextInt();
        // sv.purchase(numberBuy, amountBuy);

        // System.out.println("Relisting with @listOwnStock method, the stocks' price are taken from the @stocks ArrayList");
        // System.out.println(sv.listOwnStocks());

        // System.out.println("Testing @checkBalance method");
        // System.out.println("Account Balance: " + sv.checkBalance());

        // System.out.println("Testing @nextDay method");
        // sv.nextDay();
        
        // System.out.println("Testing @checkBalance method");
        // System.out.println("Account Balance: " + sv.checkBalance());
        // System.out.println("Relisting with @listOwnStocks method");
        // System.out.println(sv.listOwnStocks());
        // System.out.println("Relisting with @listAllStocks method");
        // System.out.println(sv.listAllStocks());

    }
    // public static void menu() {
    //     while (true) {
    //         System.out.println("\n" +
            // "+-------------------------+" + "\n" +
            // "|         OPTIONS         |" + "\n" +
            // "| [1] Login               |" + "\n" +
            // "| [2] List All Stocks     |" + "\n" +
            // "| [3] Delete a product    |" + "\n" +
            // "| [4] Edit a product      |" + "\n" +
            // "| [5] Search for products |" + "\n" +
            // "| [6] Sort product price  |" + "\n" +
            // "| [7] Save file           |" + "\n" +
            // "| [8] Load file           |" + "\n" +
            // "| [9] Exit program        |" + "\n" +
            // "+-------------------------+");
    //         System.out.print(" Input: ");
    //         Scanner sc = new Scanner(System.in);
    //         int input = sc.nextInt();
            
    //         if ((input >= 1) && (input <= 9)) {
    //             switch (input) {
    //                 case 1:
    //                     try {
    //                         // Scanner loginScanner = new Scanner(System.in);
    //                         // System.out.print("Account name: ");
    //                         // currentUser = loginScanner.nextLine();
    //                         // System.out.print("Account password: ");
    //                         // String pass = loginScanner.nextLine();
    //                         stockServer.login("nam", "pass1");
    //                         // loginScanner.close();
    //                     } catch (AccessDeniedException e) {
    //                         System.out.println("Access Denied!");
    //                     }
    //                     menu();
    //                     break;
    //                 case 2:
    //                     System.out.println("This is case 2");
    //                     stockServer.listAllStocks();
    //                     break;
    //                 // case 3:
    //                 // Feature.deleteProduct(list);
    //                 // case 4:
    //                 // Feature.editProduct(list);
    //                 // case 5:
    //                 // Feature.searchProduct(list);
    //                 // case 6:
    //                 // Feature.sortProduct(list);
    //                 // case 7:
    //                 // Feature.saveProduct(list);
    //                 // case 8:
    //                 // Feature.loadProduct(list);
    //                 case 9:
    //                     sc.close();
    //                     System.out.println("Program terminated.");
    //                     System.exit(0);
    //             }
    //         } else {
    //             menu();
    //         }
    //     }
    // }

