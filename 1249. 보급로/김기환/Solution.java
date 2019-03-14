import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
        int how_many = this.nextInt();
        for (int index_of_many = 0; index_of_many < how_many; ++index_of_many) {
            sb.append("#").append(index_of_many + 1).append(" ").append(do_times()).append("\n");
        }
        System.out.println(sb.toString());
    }

    private int do_times() {
        int number_of_length = this.nextInt();
        int[] array_x = {0, 0, 1, -1};
        int[] array_y = {1, -1, 0, 0};
        int[][] space = new int[number_of_length][number_of_length];
        for (int index_of_row = 0; index_of_row < number_of_length; ++index_of_row) {
            String line_of_input = this.next();
            for (int index_of_col = 0; index_of_col < number_of_length; ++index_of_col) {
                space[index_of_row][index_of_col] = Integer.parseInt(line_of_input.substring(index_of_col, index_of_col + 1));
            }
        }

        int[][] space_of_shortest_length = new int[number_of_length][number_of_length];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        space_of_shortest_length[0][0] = 1;
        while (!queue.isEmpty()) {
            Point now_point = queue.poll();
            for (int index_of_array = 0; index_of_array < 4; ++index_of_array) {
                int next_row = now_point.x + array_x[index_of_array];
                int next_col = now_point.y + array_y[index_of_array];
                if (0 <= next_row && 0 <= next_col && next_row < number_of_length && next_col < number_of_length) {
                    if (space_of_shortest_length[next_row][next_col] == 0) {
                        space_of_shortest_length[next_row][next_col] = space_of_shortest_length[now_point.x][now_point.y] + space[next_row][next_col];
                        queue.add(new Point(next_row, next_col));
                    } else if (space_of_shortest_length[next_row][next_col] > space_of_shortest_length[now_point.x][now_point.y] + space[next_row][next_col]) {
                        space_of_shortest_length[next_row][next_col] = space_of_shortest_length[now_point.x][now_point.y] + space[next_row][next_col];
                        queue.add(new Point(next_row, next_col));
                    }
                }
            }
        }
        return space_of_shortest_length[number_of_length - 1][number_of_length - 1] - 1;
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}