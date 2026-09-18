package section4; 
public class Act2 {
    public static void main(String[] args) {
        for (int numbers = 1; numbers <= 100; numbers++) {
            boolean primeNumber = (numbers != 1);
            for (int testNumber = 2; testNumber < numbers; testNumber++) {
                if (numbers % testNumber == 0) {
                    primeNumber = false;
                }
            }
            if (primeNumber) {
                System.out.print("[" + numbers + "]" + " ");
            }
        }

    }
}
