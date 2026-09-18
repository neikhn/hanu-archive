package section4; 
import java.util.Scanner;
public class Act3 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Insert your amount of money: ");
        double money = userInput.nextDouble();
        System.out.print("Rate: ");
        double rate = userInput.nextDouble();
        System.out.print("Amount of years: ");
        double years = userInput.nextDouble();
        userInput.close();
        for (int i = 0; i < years; i++) {
            money += money * rate / 100;
        }
        String processedMoney = String.valueOf(money);
        int indexMoney = processedMoney.indexOf(".");
        processedMoney = processedMoney.substring(0, indexMoney) + processedMoney.substring(indexMoney, indexMoney + 3);
        System.out.print("After " + years + " years, you will receive: " + processedMoney);
    }
}
