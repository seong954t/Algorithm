import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {//contest_programing
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
        int number_of_row = this.nextInt();
        int number_of_col = this.nextInt();
        int[][] test = new int[number_of_row][number_of_col];
        int[] solve_problem = new int[number_of_row];
        int max = 0;
        for (int index_of_row = 0; index_of_row < number_of_row; ++index_of_row) {
            for (int index_of_col = 0; index_of_col < number_of_col; ++index_of_col) {
                test[index_of_row][index_of_col] = this.nextInt();
                if (test[index_of_row][index_of_col] == 1) {
                    max = Math.max(max, ++solve_problem[index_of_row]);
                }
            }
        }
        int count_of_first = 0;
        for (int index_of_solve = 0; index_of_solve < number_of_row; ++index_of_solve) {
            if (solve_problem[index_of_solve] == max) {
                ++count_of_first;
            }
        }
        sb.append(count_of_first).append(" ").append(max).append("\n");
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}
