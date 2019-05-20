import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int length = sc.nextInt();
            String str = sc.next();

            do {
                length = str.length();
                for (int i = 0; i <= 9; i++) {
                    str  = str.replaceAll(i + "" + i, "");
                }
            } while (length != str.length());
            System.out.println("#" + tc + " " + str);
        }
        sc.close();
    }
}
