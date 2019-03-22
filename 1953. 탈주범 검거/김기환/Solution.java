import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {//1953_A fugitive arrest
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
        int numberOfRow = this.nextInt();
        int numberOfCol = this.nextInt();
        int spotOfWholeRow = this.nextInt();
        int spotOfWholeCol = this.nextInt();
        int howManyTimeCanMove = this.nextInt();
        int[][] space = new int[numberOfRow][numberOfCol];
        for (int indexOfRow = 0; indexOfRow < numberOfRow; ++indexOfRow) {
            for (int indexOfCol = 0; indexOfCol < numberOfCol; ++indexOfCol) {
                space[indexOfRow][indexOfCol] = this.nextInt();
            }
        }

        int[][] spaceOfMove = new int[numberOfRow][numberOfCol];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(spotOfWholeRow, spotOfWholeCol));
        spaceOfMove[spotOfWholeRow][spotOfWholeCol] = 1;
        int numberOfCanMoveInPipe = 0;
        while (!queue.isEmpty()) {
            Point nowPoint = queue.poll();

            if (spaceOfMove[nowPoint.x][nowPoint.y] == howManyTimeCanMove + 1) {
                break;
            }

            numberOfCanMoveInPipe += 1;
            int[] arrayOfRow = setDirectionOfRow(space[nowPoint.x][nowPoint.y]);
            int[] arrayOfCol = setDirectionOfCol(space[nowPoint.x][nowPoint.y]);
            for (int indexOfChange = 0; indexOfChange < arrayOfRow.length; ++indexOfChange) {
                int changeRow = nowPoint.x + arrayOfRow[indexOfChange];
                int changeCol = nowPoint.y + arrayOfCol[indexOfChange];
                if (0 <= changeRow && changeRow < numberOfRow && 0 <= changeCol && changeCol < numberOfCol &&
                        space[changeRow][changeCol] != 0 && spaceOfMove[changeRow][changeCol] == 0) {
                    int[] arrayOfOtherRow = setDirectionOfRow(space[changeRow][changeCol]);
                    int[] arrayOfOtherCol = setDirectionOfCol(space[changeRow][changeCol]);
                    for (int indexOfOtherArray = 0; indexOfOtherArray < arrayOfOtherCol.length; ++indexOfOtherArray) {
                        if (changeRow + arrayOfOtherRow[indexOfOtherArray] == nowPoint.x &&
                                changeCol + arrayOfOtherCol[indexOfOtherArray] == nowPoint.y) {
                            queue.add(new Point(changeRow, changeCol));
                            spaceOfMove[changeRow][changeCol] = 1 + spaceOfMove[nowPoint.x][nowPoint.y];
                        }
                    }
                }
            }
        }
        return numberOfCanMoveInPipe;
    }

    private int[] setDirectionOfRow(int caseOfPipe) {
        switch (caseOfPipe) {
            case 1:
                return new int[]{0, 0, -1, 1};
            case 2:
                return new int[]{-1, 1};
            case 3:
                return new int[]{0, 0};
            case 4:
                return new int[]{-1, 0};
            case 5:
                return new int[]{1, 0};
            case 6:
                return new int[]{0, 1};
            case 7:
                return new int[]{-1, 0};
        }
        return null;
    }

    private int[] setDirectionOfCol(int caseOfPipe) {
        switch (caseOfPipe) {
            case 1:
                return new int[]{1, -1, 0, 0};
            case 2:
                return new int[]{0, 0};
            case 3:
                return new int[]{-1, 1};
            case 4:
                return new int[]{0, 1};
            case 5:
                return new int[]{0, 1};
            case 6:
                return new int[]{-1, 0};
            case 7:
                return new int[]{0, -1};
        }
        return null;
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}