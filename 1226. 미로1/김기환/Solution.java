import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {//1226_maze
    private StringTokenizer _st;
    private BufferedReader _br;
    private int[] array_x = {0, 0, 1, -1};
    private int[] array_y = {1, -1, 0, 0};

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
        for (int index_of_many = 0; index_of_many < 10; ++index_of_many) {
            int now = this.nextInt();
            sb.append("#").append(now).append(" ");
            do_times(sb);
        }
        System.out.println(sb.toString());
    }

    private void do_times(StringBuilder sb) {//bfs로 풀이 stack 사용하면 더 복잡
        int[][] maze = new int[16][16];
        for (int index_of_row = 0; index_of_row < 16; ++index_of_row) {
            String input = this.next();
            for (int index_of_col = 15; index_of_col >= 0; --index_of_col) {
                maze[index_of_row][index_of_col] = -Integer.parseInt(input.substring(index_of_col, index_of_col + 1));
            }
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1));
        maze[1][1] = 2;
        while (!queue.isEmpty()) {
            Point now_point = queue.poll();
            for (int index_of_array = 0; index_of_array < 4; ++index_of_array) {
                int now_x = now_point._row + array_x[index_of_array];
                int now_y = now_point._col + array_y[index_of_array];
                if (0 <= now_x && now_x < 16 && 0 <= now_y && now_y < 16) {
                    if (maze[now_x][now_y] == -3) {
                        sb.append(1).append("\n");
                        return;
                    } else if (maze[now_x][now_y] == 0) {
                        maze[now_x][now_y] = 2;
                        queue.add(new Point(now_x, now_y));
                    }
                }
            }
        }
        sb.append(0).append("\n");
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}

class Point {
    int _row, _col;

    public Point(int row, int col) {
        this._row = row;
        this._col = col;
    }
}
