import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int TC = sc.nextInt();
            String sub = sc.next();
            String str = sc.next();
            str = str.replaceAll(sub, " ");
            int result = 0;
            while(str.contains(" ")) {
                result++;
                str = str.replaceFirst(" ", "");
            }
            System.out.println("#" + TC + " " + result);
        }
        sc.close();
    }
}
