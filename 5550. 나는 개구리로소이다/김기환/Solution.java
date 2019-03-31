import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {//5550 나는 개구리로소이다
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
        String sound = this.next();
        char[] soundOfData = sound.toCharArray();
        int[] array = new int[5];
        int numberOfFlog = 0;
        for (char nowSound : soundOfData) {
            switch (nowSound) {
                case 'c':
                    if (array[4] != 0) {
                        numberOfFlog -= 1;
                        array[4] -= 1;
                    }
                    numberOfFlog += 1;
                    array[0] += 1;
                    break;
                case 'r':
                    if (array[0] < 1) {
                        return -1;
                    }
                    array[0] -= 1;
                    array[1] += 1;
                    break;
                case 'o':
                    if (array[1] < 1) {
                        return -1;
                    }
                    array[1] -= 1;
                    array[2] += 1;
                    break;
                case 'a':
                    if (array[2] < 1) {
                        return -1;
                    }
                    array[2] -= 1;
                    array[3] += 1;
                    break;
                case 'k':
                    if (array[3] < 1) {
                        return -1;
                    }
                    array[3] -= 1;
                    array[4] += 1;
                    break;
            }
        }
        for (int index = 0; index < array.length - 1; ++index) {
            if (array[index] != 0) {
                return -1;
            }
        }
        if (array[4] == numberOfFlog) {
            return numberOfFlog;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}