import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {//1226_maze
    private StringTokenizer _st;
    private BufferedReader _br;

    private String readLine() {
        try {
            return this._br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private String next() {
        while (!this._st.hasMoreTokens()) {
            this._st = new StringTokenizer(this.readLine());
        }
        return this._st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(this.next());
    }

    private void init() {
        this._st = new StringTokenizer("");
        this._br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void solve() {
        this.init();
        StringBuilder sb = new StringBuilder();
        int how_many = this.nextInt();
        for (int index_of_many = 0; index_of_many < how_many; ++index_of_many) {
            sb.append("#").append(index_of_many + 1).append(" ");
            do_times(sb);
        }
        System.out.println(sb.toString());
    }

    private void do_times(StringBuilder sb) {
        int number_of_metal = this.nextInt();
        int[][] meterial = new int[4][number_of_metal];

        Queue<Integer> queue = new LinkedList<>();//지정 안된 위치를 저장

        for (int index_of_row = 0; index_of_row < number_of_metal; ++index_of_row) {
            meterial[0][index_of_row] = this.nextInt();
            meterial[1][index_of_row] = this.nextInt();
            meterial[2][index_of_row] = -1;
            meterial[3][index_of_row] = -1;
            queue.add(index_of_row);
        }

        int head_index;
        int tail_index;

        if (queue.isEmpty()) {
            return;
        } else {
            head_index = queue.poll();
            tail_index = head_index;
        }

        while (!queue.isEmpty()) {
            meterial[2][head_index] = -100;
            meterial[3][tail_index] = -50;
            Iterator<Integer> iterator = queue.iterator();
            while (iterator.hasNext()) {
                int other_index = iterator.next();
                if (meterial[1][other_index] == meterial[0][head_index]) {
                    meterial[2][other_index] = -100;
                    meterial[3][other_index] = head_index;
                    meterial[2][head_index] = other_index;
                    head_index = other_index;
                    iterator.remove();
                } else if (meterial[0][other_index] == meterial[1][tail_index]) {
                    meterial[3][other_index] = -50;
                    meterial[2][other_index] = tail_index;
                    meterial[3][tail_index] = other_index;
                    tail_index = other_index;
                    iterator.remove();
                }
            }
        }

        int head = head_index;
        while (true) {
            sb.append(meterial[0][head]).append(" ").append(meterial[1][head]).append(" ");
            if (meterial[3][head] == -50) {
                break;
            }
            head = meterial[3][head];
        }
        sb.append("\n");
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}
