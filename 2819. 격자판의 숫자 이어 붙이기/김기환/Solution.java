import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {//2819 격자판의 숫자 이어 붙이기
    private BufferedReader _br;
    private StringTokenizer _st;
    private static int[] arrayOfRow = {0, 0, 1, -1};
    private static int[] arrayOfCol = {1, -1, 0, 0};
    Set<Integer> set;

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

        set = new HashSet<>();
        for (int indexOfRow = 0; indexOfRow < 4; ++indexOfRow) {
            for (int indexOfCol = 0; indexOfCol < 4; ++indexOfCol) {
                this.dfs(space, 7, new Point(indexOfRow, indexOfCol), space[indexOfRow][indexOfCol]);
            }
        }
        return set.size();
    }

    private void dfs(int[][] space, int dept, Point nowPoint, int addNumber) {
        if (dept == 1) {
            set.add(addNumber);
            return;
        }
        for (
                int indexOfArray = 0;
                indexOfArray < 4; ++indexOfArray) {
            int nowRow = nowPoint.x + arrayOfRow[indexOfArray];
            int nowCol = nowPoint.y + arrayOfCol[indexOfArray];
            if (0 <= nowRow && nowRow < 4 && 0 <= nowCol && nowCol < 4) {
                int changeAddNumber = addNumber * 10;
                changeAddNumber += space[nowRow][nowCol];
                this.dfs(space, dept - 1, new Point(nowRow, nowCol), changeAddNumber);
            }
        }

    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}