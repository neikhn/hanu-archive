package section5;
public class Act3Review {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (String.valueOf(i * j).length() == 1) {
                    System.out.print("   ");
                } else if (String.valueOf(i * j).length() == 2) {
                    System.out.print("  ");
                } else if (String.valueOf(i * j).length() == 3) {
                    System.out.print(" ");
                }
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }
}
