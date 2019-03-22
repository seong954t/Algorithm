import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SolutionOtherWay {//2819 격자판의 숫자 이어 붙이기
    private BufferedReader _br;
    private StringTokenizer _st;
    private int[] arrayOfRow = {0, 0, 1, -1};
    private int[] arrayOfCol = {1, -1, 0, 0};


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
        int howMany = this.nextInt();
        for (int indexOfMany = 0; indexOfMany < howMany; ++indexOfMany) {
            sb.append("#").append(indexOfMany + 1).append(" ").append(doTimes()).append("\n");
        }
        System.out.println(sb.toString());
    }

    private int doTimes() {
        int[][] space = new int[4][4];
        for (int indexOfRow = 0; indexOfRow < 4; ++indexOfRow) {
            for (int indexOfCol = 0; indexOfCol < 4; ++indexOfCol) {
                space[indexOfRow][indexOfCol] = this.nextInt();
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int indexOfRow = 0; indexOfRow < 4; ++indexOfRow) {
            for (int indexOfCol = 0; indexOfCol < 4; ++indexOfCol) {
                this.bfs(space, new Point(indexOfRow, indexOfCol, 1, space[indexOfRow][indexOfCol]), set);
            }
        }
        return set.size();
    }

    private void bfs(int[][] space, Point nowPoint, Set<Integer> set) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(nowPoint);
        while (!queue.isEmpty()) {
            Point tempPoint = queue.poll();
            if (tempPoint._depth == 7) {
                set.add(tempPoint._number);
            } else if (tempPoint._depth == 8) {
                return;
            }
            for (int indexOfArray = 0; indexOfArray < 4; ++indexOfArray) {
                int changeRow = tempPoint._row + this.arrayOfRow[indexOfArray];
                int changeCol = tempPoint._col + this.arrayOfCol[indexOfArray];
                if (0 <= changeRow && changeRow < 4 && 0 <= changeCol && changeCol < 4) {
                    queue.add(new Point(changeRow, changeCol, tempPoint._depth + 1, tempPoint._number * 10 + space[changeRow][changeCol]));
                }
            }
        }
    }

    public static void main(String[] args) {
        SolutionOtherWay main = new SolutionOtherWay();
        main.solve();
    }
}

class Point {
    int _row, _col, _depth, _number;

    public Point(int x, int y, int depth, int number) {
        this._row = x;
        this._col = y;
        this._depth = depth;
        this._number = number;
    }
}