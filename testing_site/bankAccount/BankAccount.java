package bankAccount;

public class BankAccount {
    private int accountNumber;
    private int accountBalance;
    private String customerName;
    private String email;
    private int phoneNumber;

    public BankAccount() {
        accountBalance = 100_000;
    }
    
    public void depositFund(int deposit) {
        accountBalance += deposit;
    }
    
    public void withdrawFund(int withdraw) {
        if ((accountBalance - withdraw) >= 50_000) {
            accountBalance -= withdraw;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void displayCustomer() {
        System.out.println("Customer name: " + getCustomerName());
        System.out.printf("Account balance: %,d (vnd) %n", getAccountBalance());
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
