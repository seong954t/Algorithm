import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {//4301 콩많이 심기
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
        int howMany = this.nextInt();
        for (int indexOfMany = 0; indexOfMany < howMany; ++indexOfMany) {
            sb.append("#").append(indexOfMany + 1).append(" ").append(doTimes()).append("\n");
        }
        System.out.println(sb.toString());
    }

    private int doTimes() {
        int[] arrayOfRow = {0, 0, 2, -2};
        int[] arrayOfCol = {2, -2, 0, 0};
        int numberOfCol = this.nextInt();
        int numberOfRow = this.nextInt();
        boolean[][] beanSpace = new boolean[numberOfRow][numberOfCol];
        int numberOfBeans = 0;
        for (int indexOfRow = 0; indexOfRow < numberOfRow; ++indexOfRow) {
            for (int indexOfCol = 0; indexOfCol < numberOfCol; ++indexOfCol) {
                if (!beanSpace[indexOfRow][indexOfCol]) {
                    boolean isCanDo = true;
                    for (int indexOfArray = 0; indexOfArray < 4; ++indexOfArray) {
                        int indexOfNowRow = indexOfRow + arrayOfRow[indexOfArray];
                        int indexOfNowCol = indexOfCol + arrayOfCol[indexOfArray];
                        if (0 <= indexOfNowRow && indexOfNowRow < numberOfRow && 0 <= indexOfNowCol && indexOfNowCol < numberOfCol
                                && beanSpace[indexOfNowRow][indexOfNowCol]) {
                            isCanDo = false;
                            break;
                        }
                    }
                    if (isCanDo) {
                        beanSpace[indexOfRow][indexOfCol] = true;
                        numberOfBeans += 1;
                    }
                }
            }
        }
        return numberOfBeans;
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}