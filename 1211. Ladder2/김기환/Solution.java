import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {//1211 ladder
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
        int howMany = 10;//this.nextInt();
        for (int indexOfMany = 0; indexOfMany < howMany; ++indexOfMany) {
            sb.append("#").append(indexOfMany + 1).append(" ").append(doTimes()).append("\n");
        }
        System.out.println(sb.toString());
    }

    private int doTimes() {
        this.nextInt();
        int lenght = 100;
        int[][] ladderData = new int[lenght][lenght];
        Queue<Point> queue = new LinkedList<>();
        for (int indexOfRow = 0; indexOfRow < lenght; ++indexOfRow) {
            for (int indexOfCol = 0; indexOfCol < lenght; ++indexOfCol) {
                ladderData[indexOfRow][indexOfCol] = this.nextInt();
                if (indexOfRow == 0 && ladderData[indexOfRow][indexOfCol] == 1) {
                    queue.add(new Point(indexOfRow, indexOfCol));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int min_index = -1;
        while (!queue.isEmpty()) {
            boolean[][] visitied = new boolean[lenght][lenght];
            Point startPoint = queue.poll();
            int nowPointRow = startPoint.x;
            int nowPointCol = startPoint.y;
            int count = 0;
            visitied[nowPointRow][nowPointCol] = true;
            while (true) {
                if (nowPointCol - 1 >= 0 && nowPointCol - 1 < lenght && !visitied[nowPointRow][nowPointCol - 1] && ladderData[nowPointRow][nowPointCol - 1] == 1) {
                    nowPointCol -= 1;
                    count += 1;
                } else if (nowPointCol + 1 >= 0 && nowPointCol + 1 < lenght && !visitied[nowPointRow][nowPointCol + 1] && ladderData[nowPointRow][nowPointCol + 1] == 1) {
                    nowPointCol += 1;
                    count += 1;
                } else {
                    nowPointRow += 1;
                    count += 1;
                }


                if (nowPointRow == lenght) {
                    if (min >= count) {
                        min = count;
                        min_index = startPoint.y;
                    }
                    break;
                }
                visitied[nowPointRow][nowPointCol] = true;

            }
        }
        return min_index;
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}