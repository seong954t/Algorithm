import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {//1249 supply route
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
            sb.append("#").append(index_of_many + 1).append(" ").append(do_times()).append("\n");
        }
        System.out.println(sb.toString());
    }

    private int do_times() {
        int[] count_of_height = new int[101];
        int number_of_change = this.nextInt();
        int min_index = Integer.MAX_VALUE;
        int max_index = 0;
        for (int index = 0; index < 100; ++index) {
            int now = this.nextInt();
            min_index = Math.min(min_index, now);
            max_index = Math.max(now, max_index);
            count_of_height[now] += 1;
        }
        for (int index = 0; index < number_of_change; ++index) {
            count_of_height[max_index] -= 1;
            count_of_height[min_index] -= 1;
            count_of_height[max_index - 1] += 1;
            count_of_height[min_index + 1] += 1;
            if (count_of_height[max_index] == 0) {
                max_index -= 1;
            }
            if (count_of_height[min_index] == 0) {
                min_index += 1;
            }
        }
        return max_index - min_index;
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}