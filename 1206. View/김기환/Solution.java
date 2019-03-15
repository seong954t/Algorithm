import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {//1206_view
    private StringTokenizer _st;
    private BufferedReader _br;
    private int[] array_reduce_index = {-2, -1, 1, 2};

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
            sb.append("#").append(index_of_many + 1).append(" ");
            do_times(sb);
        }
        System.out.println(sb.toString());
    }

    private void do_times(StringBuilder sb) {
        int number_of_building = this.nextInt();
        int[] building = new int[number_of_building];
        for (int index_of_building = 0; index_of_building < number_of_building; ++index_of_building) {
            building[index_of_building] = this.nextInt();
        }
        int sum = 0;
        for (int index_of_building = 0; index_of_building < number_of_building; ++index_of_building) {
            int min = Integer.MAX_VALUE;
            for (int index_of_array = 0; index_of_array < 4; ++index_of_array) {
                int now_index = array_reduce_index[index_of_array] + index_of_building;
                if (0 <= now_index && now_index < number_of_building) {
                    int sub = building[index_of_building] - building[now_index];
                    if (sub >= 0) {
                        min = Math.min(min, sub);
                    } else {
                        min = 0;
                        break;
                    }
                }
            }
            sum += min;
        }
        sb.append(sum).append("\n");
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}