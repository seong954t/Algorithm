import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt();
            int result = 0;
            if (N < 100) {
                result = 0;
            } else if (100 <= N && N < 1000) {
                result = 1;
            } else if (1000 <= N && N < 10000) {
                result = 2;
            } else if (10000 <= N && N < 100000) {
                result = 3;
            } else if (100000 <= N && N < 1000000) {
                result = 4;
            } else {
                result = 5;
            }
            System.out.println("#" + tc + " " + result);
        }
        sc.close();
    }
}
