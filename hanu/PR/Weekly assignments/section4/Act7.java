package section4;
public class Act7 {
    public static void main(String[] args) {
        System.out.print("Armstrong number: ");
        int x, sum = 0, temp;
        for (int i = 100; i < 1000; i++) {
            temp = i;
            sum = 0;
            for (int j = 1; j <= String.valueOf(i).length(); j++) {
                x = temp % 10;
                temp = temp / 10;
                sum = sum + (x * x * x);
            }
            // System.out.print(sum + " ");
            if (sum == i) {
                System.out.print("[" + sum + "] ");
            }
        }
    }
}
