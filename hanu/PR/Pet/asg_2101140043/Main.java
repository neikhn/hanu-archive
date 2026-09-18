package asg_2101140043;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        list.add(0, new Product("banh bao thu nghiem", 10_000, 1));
        list.add(0, new Product("banh MY thu nghiem", 11_000, 5));
        list.add(0, new Product("BANH te thu nghiem", 15_000, 4));
        menu(list);
    }
    // options menu
    public static void menu(ArrayList<Product> list) {
        while (true) {
            System.out.println("\n" +
                "+-------------------------+" + "\n" +
                "|         OPTIONS         |" + "\n" +
                "| [1] Add a product       |" + "\n" +
                "| [2] View all products   |" + "\n" +
                "| [3] Delete a product    |" + "\n" +
                "| [4] Edit a product      |" + "\n" +
                "| [5] Search for products |" + "\n" +
                "| [6] Sort product price  |" + "\n" +
                "| [7] Save file           |" + "\n" +
                "| [8] Load file           |" + "\n" +
                "| [9] Exit program        |" + "\n" +
                "+-------------------------+");
            System.out.print(" Input: ");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            if ((input >= 1) && (input <= 9)) {
                switch (input) {
                    case 1:
                        Feature.addProduct(list);
                        menu(list);
                    case 2:
                        Feature.viewProduct(list);
                    case 3:
                        Feature.deleteProduct(list);
                    case 4:
                        Feature.editProduct(list);
                    case 5:
                        Feature.searchProduct(list);
                    case 6:
                        Feature.sortProduct(list);
                    case 7:
                        Feature.saveProduct(list);
                    case 8:
                        Feature.loadProduct(list);
                    case 9:
                        sc.close();
                        System.out.println("Program terminated.");
                        System.exit(0);
                }
            } else {
                retryMenu(list);
            }
        }
    }
    // when the user reach for invalid option of the menu
    public static void retryMenu(ArrayList<Product> list) {
        while (true) {
            System.out.println("\n" + "NO SUCH OPTION!");
            System.out.println("[1] Try again");
            System.out.println("[2] Exit");
            System.out.print("Input: ");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            if ((input >= 1) && (input <= 2)) {
                switch (input) {
                    case 1:
                        menu(list);
                        break;
                    case 2:
                        sc.close();
                        System.out.println("\n" + "Program terminated.");
                        System.exit(0);
                        break;
                }
            } else {
                retryMenu(list);
            }
        }
    }
    // when user add a product or view all products [FEATURE 1 & FEATURE2]
    public static void retryMenu1(ArrayList<Product> list) {
        while (true) {
            System.out.println("[1] Add a product");
            System.out.println("[2] Edit a product");
            System.out.println("[3] Delete a product");
            System.out.println("[4] Back to menu");
            System.out.println("[5] Exit");
            System.out.print("Input: ");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            if ((input >= 1) && (input <= 5)) {
                switch (input) {
                    case 1:
                        Feature.addProduct(list);
                        break;
                    case 2:
                        Feature.editProduct(list);
                        break;
                    case 3:
                        Feature.deleteProduct(list);
                        break;
                    case 4:
                        menu(list);
                        break;
                    case 5:
                        System.out.println("\n" + "Program terminated.");
                        sc.close();
                        System.exit(0);
                        break;
                }
            } else {
                retryMenu1(list);
            }
        }
    }
    // when user remove a product [FEATURE 3]
    public static void retryMenu2(ArrayList<Product> list) {
        while (true) {
            System.out.println("[1] Remove another product");
            System.out.println("[2] View all products");
            System.out.println("[3] Back to menu");
            System.out.println("[4] Exit");
            System.out.print("Input: ");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            if ((input >= 1) && (input <= 4)) {
                switch (input) {
                    case 1:
                        Feature.deleteProduct(list);
                        break;
                    case 2:
                        Feature.viewProduct(list);
                    case 3:
                        menu(list);
                        break;
                    case 4:
                        sc.close();
                        System.out.println("\n" + "Program terminated.");
                        System.exit(0);
                        break;
                }
            } else {
                retryMenu2(list);
            }
        }
    }
    // when user remove/edit/search/sort product when list is null
    public static void retryMenu3(ArrayList<Product> list) {
        while (true) {
            System.out.println("[1] Add a product");
            System.out.println("[2] Back to menu");
            System.out.println("[3] Exit");
            System.out.print("Input: ");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            if ((input >= 1) && (input <= 3)) {
                switch (input) {
                    case 1:
                        Feature.addProduct(list);
                        break;
                    case 2:
                        menu(list);
                        break;
                    case 3:
                        sc.close();
                        System.out.println("\n" + "Program terminated.");
                        System.exit(0);
                        break;
                }
            } else {
                retryMenu3(list);
            }
        }
    }
    // when user edit a product [FEATURE 4]
    public static void retryMenu4(ArrayList<Product> list) {
        while (true) {
            System.out.println("[1] Edit another product");
            System.out.println("[2] View all products");
            System.out.println("[3] Back to menu");
            System.out.println("[4] Exit");
            System.out.print("Input: ");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            if ((input >= 1) && (input <= 4)) {
                switch (input) {
                    case 1:
                        Feature.editProduct(list);
                        break;
                    case 2:
                        Feature.viewProduct(list);
                        break;
                    case 3:
                        menu(list);
                        break;
                    case 4:
                        sc.close();
                        System.out.println("\n" + "Program terminated.");
                        System.exit(0);
                        break;
                }
            } else {
                retryMenu4(list);
            }
        }
    }

    public static void retryMenu5(ArrayList<Product> list) {
        while (true) {
            System.out.println("[1] Search for another product");
            System.out.println("[2] View all products");
            System.out.println("[3] Back to menu");
            System.out.println("[4] Exit");
            System.out.print("Input: ");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            if ((input >= 1) && (input <= 4)) {
                switch (input) {
                    case 1:
                        Feature.searchProduct(list);
                        break;
                    case 2:
                        Feature.viewProduct(list);
                    case 3:
                        menu(list);
                        break;
                    case 4:
                        sc.close();
                        System.out.println("\n" + "Program terminated.");
                        System.exit(0);
                        break;
                }
            } else {
                retryMenu2(list);
            }
        }
    }
}