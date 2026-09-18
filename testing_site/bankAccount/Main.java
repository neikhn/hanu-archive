package bankAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount kian = new BankAccount();
        kian.setCustomerName("Nguyen Hoang Kien");
        displayUI(kian);
    }

    public static void displayUI(BankAccount kian) {
        loop: while (true) {
            System.out.println("\n");
            System.out.println("| [1] Display customer information. |");
            System.out.println("| [2] Deposit funds.                |");
            System.out.println("| [3] Withdraw funds.               |");
            System.out.println("| [4] Exit.                         |");
            System.out.print("Input: ");
            Scanner sc = new Scanner(System.in);
            int temp = sc.nextInt();
            System.out.println("\n");


            switch (temp) {
                case 1:
                    kian.displayCustomer();
                    displayUI(kian);
                case 2:
                    System.out.print("Deposit funds: ");
                    int deposit = sc.nextInt();
                    kian.depositFund(deposit);
                    displayUI(kian);
                case 3:
                    System.out.print("Withdraw funds: ");
                    int withdraw = sc.nextInt();
                    kian.withdrawFund(withdraw);
                    displayUI(kian);
                case 4:
                    sc.close();
                    break loop;
            }
        }
    }
}