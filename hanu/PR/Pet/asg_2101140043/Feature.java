package asg_2101140043;

import java.util.*;
import java.io.*;

public class Feature extends Main {
  static int number = 0;

  // [FEATURE 1]
  public static void addProduct(ArrayList<Product> list) {
    Scanner sc = new Scanner(System.in);
    String name;
    long price;
    long quantity;

    System.out.println("");
    System.out.print("Product name: ");
    name = sc.nextLine();
    System.out.print("Product price: ");
    price = sc.nextLong();
    System.out.print("Product quantity: ");
    quantity = sc.nextLong();

    for (int i = 0; i < list.size(); i++) {
      if ((name.equals(list.get(i).name))) {
        System.out.println("\n" + "This product already existed!");
        retryMenu1(list);
      }
    }
    list.add(new Product(name, price, quantity));
    System.out.println("\n" + "Product added: " + "\"" + name + "\"");
    retryMenu1(list);
    sc.close();
  }

  // [FEATURE 2]
  public static void viewProduct(ArrayList<Product> list) {
    // if list contains no product
    if (list.size() < 1) {
      System.out.println("\n" + "Nothing found!");
      retryMenu1(list);
    }
    // list all products
    System.out.println("\n" +
        "+----------------------------------------------------------------------------+" + "\n" +
        "|                                PRODUCTS LIST                               |" + "\n" +
        "+----------------------------------------------------------------------------+" + "\n" +
        "| ID    | Name                 | Price                | Quantity             |");

    for (int i = 0; i < list.size(); i++) {
      (list.get(i)).information();
    }

    System.out.println(
        "+----------------------------------------------------------------------------+");
    retryMenu1(list);
  }

  // [FEATURE 3]
  public static void deleteProduct(ArrayList<Product> list) {
    // if list contains no product
    if (list.size() < 1) {
      System.out.println("\n" + "No existing product!");
      retryMenu3(list);
    }
    // remove product
    Scanner sc = new Scanner(System.in);
    System.out.print("\n" + "Enter the product ID: ");
    String id = sc.nextLine();
    for (int i = 0; i < list.size(); i++) {
      if ((list.get(i).getID()).equals(id)) {
        System.out.println("Product removed: " + list.get(i).getName());
        list.remove(i);
        return;
      }
      // this should be (i == (list.size() - 1)) 
      // since list.size() = the amount of index in list 
      else if (i == (list.size() - 1)) {
        System.out.println("Invalid ID!");
      }
    }
    retryMenu2(list);
  }

  // [FEATURE 4]
  public static void editProduct(ArrayList<Product> list) {
    // if list contains no product
    if (list.size() < 1) {
      System.out.println("\n" + "No existing product!");
      retryMenu3(list);
    }
    // edit product
    Scanner sc = new Scanner(System.in);
    System.out.print("\n" + "Enter the product ID: ");
    String id = sc.nextLine();

    for (int i = 0; i < list.size(); i++) {
      if ((list.get(i).getID()).equals(id)) {
        System.out.println("\n" +
            "+----------------------------------------------------------------------------+" + "\n" +
            "|                            PRODUCTS INFORMATION                            |" + "\n" +
            "+----------------------------------------------------------------------------+" + "\n" +
            "| ID    | Name                 | Price                | Quantity             |");

        (list.get(i)).information();
        System.out.println(
            "+----------------------------------------------------------------------------+");
        // editing menu
        loop: while (true) {
          System.out.println("\n" + "EDIT:");
          System.out.println("[1] Name");
          System.out.println("[2] Price");
          System.out.println("[3] Quantity ");
          System.out.println("[4] Edit another product ");
          System.out.println("[5] Back to menu ");
          System.out.print("Input: ");
          int input = sc.nextInt();

          if ((input >= 1) && (input <= 5)) {
            switch (input) {
              // edit name
              case 1:
                String tempName = list.get(i).getName();
                System.out.print("Name: ");
                sc.nextLine();
                String nameChanger = sc.nextLine();
                list.get(i).setName(nameChanger);
                String tempNameChanged = list.get(i).getName();
                System.out.println("\n" + "Name changed from " + "\"" + tempName + "\"" +
                    " to " + "\"" + tempNameChanged + "\"");
                continue loop;
              //edit price
              case 2:
                long tempPrice = list.get(i).getPrice();
                System.out.print("Price: ");
                sc.nextLine();
                long priceChanger = sc.nextLong();
                list.get(i).setPrice(priceChanger);
                long tempPriceChanged = list.get(i).getPrice();
                System.out.println("\n" + "Price changed from " + "\"" + tempPrice + "\"" +
                    " to " + "\"" + tempPriceChanged + "\"");
                continue loop;
              // edit quantity
              case 3:
                long tempQuantity = list.get(i).getQuantity();
                System.out.print("Quantity: ");
                sc.nextLine();
                long quantityChanger = sc.nextLong();
                list.get(i).setQuantity(quantityChanger);
                long tempQuantityChanged = list.get(i).getQuantity();
                System.out.println("\n" + "Quantity changed from " + "\"" + tempQuantity + "\"" +
                    " to " + "\"" + tempQuantityChanged + "\"");
                continue loop;
              case 4:
                Feature.editProduct(list);
              case 5:
                menu(list);
            }
          } else {
            System.out.println("Test");
            while (true) {
              System.out.println("\n" + "NO SUCH OPTION!");
              System.out.println("[1] Try again");
              System.out.println("[2] Exit");
              System.out.print("Input: ");
              int input1 = sc.nextInt();

              if ((input1 >= 1) && (input1 <= 2)) {
                switch (input1) {
                  case 1:
                    continue loop;
                  case 2:
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
        }
      } else if (i == (list.size() - 1)) {
        System.out.println("Invalid ID!");
        retryMenu4(list);
        sc.close();
      }
    }
  }

  // [FEATURE 5]
  public static void searchProduct(ArrayList<Product> list) {
    // if list contains no product
    if (list.size() < 1) {
      System.out.println("\n" + "No existing product!");
      retryMenu3(list);
    }

    Scanner sc = new Scanner(System.in);
    System.out.print("Input keyword: ");
    String name = sc.nextLine();

    System.out.println("\n" +
        "+----------------------------------------------------------------------------+" + "\n" +
        "|                                PRODUCTS LIST                               |" + "\n" +
        "+----------------------------------------------------------------------------+" + "\n" +
        "| ID    | Name                 | Price                | Quantity             |");

    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getName().contains(name.toLowerCase())) {
        list.get(i).information();
        number++;
      }
    }
    System.out.println(
        "+----------------------------------------------------------------------------+");
    System.out.println("Found " + number + " result(s)");
    // since number is static, it's reset after the loop is done incase  user reopen
    // the search method
    number = 0;
    retryMenu5(list);
    sc.close();
  }
  // [FEATURE 6]
  public static void sortProduct(ArrayList<Product> list) {
    // if list contain no product
    if (list.size() < 1) {
      System.out.println("\n" + "No existing product!");
      retryMenu3(list);
    }
    // create another arraylist to store value from the original one
    Long price;
    List<Long> priceSort = new ArrayList<>();
    
    System.out.println("\n" +
      "+----------------------------------------------------------------------------+" + "\n" +
      "|                                 SORTED LIST                                |" + "\n" +
      "+----------------------------------------------------------------------------+" + "\n" +
      "| ID    | Name                 | Price                | Quantity             |");
    
      for (int i = 0; i < list.size(); i++) {
      priceSort.add(list.get(i).price);
    }
    Collections.sort(priceSort);
    
    while (!priceSort.isEmpty()) {
      price = priceSort.get(0);
      
      for (int i = 0; i < list.size(); i++) {
        if (price == list.get(i).price) {
          list.get(i).information();
          priceSort.remove(0);
          break;
        }
      }
    }
    System.out.println(
      "+----------------------------------------------------------------------------+");
    retryMenu1(list);
  }
  // [FEATURE 7]
  public static void saveProduct(ArrayList<Product> list) {
    File file = new File("product");
    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(file);
      for (int i = 0; i < list.size(); i++) {
        String fileLine = list.get(i).getFileLine();
        byte[] save = fileLine.getBytes();
        fos.write(save);
      }
    } catch (Exception e) {
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (Exception e) {
        }
      }
    }
    System.out.println("\n" + "File successfully saved!");
    menu(list);
  }

  // [FEATURE 8]
  public static void loadProduct(ArrayList<Product> list) {
    list.clear();
    FileInputStream fis = null;
    InputStreamReader isr = null;
    BufferedReader br = null;
    try {
      fis = new FileInputStream("product");
      isr = new InputStreamReader(fis);
      br = new BufferedReader(isr);
      String fileLine = null;
      // if the (fileLine = br.readLine()) is null, the reader is already 
      // at the end of the file
      while ((fileLine = br.readLine()) != null) {
        // if a file line is emty, that won't be loaded into the program
        if (fileLine.isEmpty()) {
          continue;
        }
        Product p = new Product();
        p.reader(fileLine);
        list.add(p);
      }
    } catch (Exception e) {
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (Exception e) {
        }
      }
      if (isr != null) {
        try {
          isr.close();
        } catch (Exception e) {
        }
      }
      if (br != null) {
        try {
          br.close();
        } catch (Exception e) {
        }
      }
      System.out.println("\n" + "File successfully loaded!");
      Feature.viewProduct(list);
    }
  }
}