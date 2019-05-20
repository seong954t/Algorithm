import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int TC = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                queue.add(sc.nextInt());
            }
            int minus = 1;
            int poll = queue.poll();
            while (poll - minus > 0) {
                queue.add(poll - minus);
                if((minus + 1) % 6 == 0) {
                    minus = 1;
                } else {
                    minus++;
                }
                poll = queue.poll();
            }
            System.out.print("#" + TC);
            while (!queue.isEmpty()){
                System.out.print(" " + queue.poll());
            }
            System.out.println(" 0");
        }
        sc.close();
    }
}
