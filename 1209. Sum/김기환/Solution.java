import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {//1209_sum
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
        int how_many = 10;
        for (int index_of_many = 0; index_of_many < how_many; ++index_of_many) {
            sb.append("#");
            do_times(sb);
        }
        System.out.println(sb.toString());
    }

    private void do_times(StringBuilder sb) {
        sb.append(this.nextInt()).append(" ");
        int[][] array = new int[100][100];
        int max = 0;
        int[] storeage_of_col = new int[100];
        for (int index_of_row = 0; index_of_row < 100; ++index_of_row) {
            int row_sum = 0;
            for (int index_of_col = 0; index_of_col < 100; ++index_of_col) {
                array[index_of_row][index_of_col] = this.nextInt();
                row_sum += array[index_of_row][index_of_col];
                storeage_of_col[index_of_col] += array[index_of_row][index_of_col];
            }
            max = Math.max(row_sum, max);
        }

        int x_of_right = 0;
        int x_of_left = 0;
        for (int index_of_row = 0; index_of_row < 100; ++index_of_row) {
            x_of_right += array[index_of_row][index_of_row];
            max = Math.max(max, storeage_of_col[index_of_row]);
        }
        max = Math.max(x_of_right, max);
        for (int index_of_row = 99; index_of_row >= 0; --index_of_row) {
            x_of_left += array[index_of_row][index_of_row];
        }
        max = Math.max(x_of_left, max);
        sb.append(max).append("\n");
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}
