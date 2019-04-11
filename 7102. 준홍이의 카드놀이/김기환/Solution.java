import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {//7193 승현이의 수학공부
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


    private String doTimes() {
        int numberOfFirstCard = this.nextInt();
        int numberOfSecondCard = this.nextInt();
        int[] storeageOfSumCard = new int[numberOfFirstCard + numberOfSecondCard + 2];

        for (int indexOfFirst = 1; indexOfFirst <= numberOfFirstCard; indexOfFirst++) {
            for (int indexOfSecond = 1; indexOfSecond <= numberOfSecondCard; indexOfSecond++) {
                storeageOfSumCard[indexOfFirst + indexOfSecond] += 1;
            }
        }
        int maxNumber = Integer.MIN_VALUE;
        StringBuilder maxNumberIndex = new StringBuilder();
        for (int index = 0; index < storeageOfSumCard.length; index++) {
            maxNumber = Math.max(maxNumber, storeageOfSumCard[index]);
        }
        for (int index = 0; index < storeageOfSumCard.length; index++) {
            if (maxNumber == storeageOfSumCard[index]) {
                maxNumberIndex.append(index + " ");
            }
        }
        return maxNumberIndex.toString();
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}