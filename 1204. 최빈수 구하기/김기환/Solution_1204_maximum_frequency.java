import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {//1204
    private BufferedReader _br;
    private StringTokenizer _st;

    private String readLine() {
        try {
            return this._br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private String next() {
        do {
            this._st = new StringTokenizer(this.readLine());
        } while (!this._st.hasMoreTokens());
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
            sb.append("#").append(index_of_many + 1).append(" ").append(do_times()).append("\n");
        }
        System.out.println(sb.toString());
    }

    private int do_times() {
        this.nextInt();
        int[] score = new int[101];
        for (int index_of_input_data = 0; index_of_input_data < 1000; ++index_of_input_data) {
            score[this.nextInt()]++;
        }

        int max = -1;
        int score_of_max_number = -1;
        for (int index_of_array = 0; index_of_array <= 100; ++index_of_array) {
            if (max <= score[index_of_array]) {
                max = score[index_of_array];
                score_of_max_number = index_of_array;
            }
        }
        return score_of_max_number;
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}