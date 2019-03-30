import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {//4050 재관이의 대량 할인
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
        int numberOfInput = this.nextInt();
        int[] priceOfClothe = new int[numberOfInput];
        for (int indexOfInput = 0; indexOfInput < numberOfInput; ++indexOfInput) {
            priceOfClothe[indexOfInput] = this.nextInt();
        }

        Integer[] priceOfClotheOfObj = Arrays.stream(priceOfClothe).boxed().toArray(Integer[]::new);
        Arrays.sort(priceOfClotheOfObj, Collections.reverseOrder());
        int count = 1;
        int sum = 0;
        for (int number : priceOfClotheOfObj) {
            if (count % 3 != 0) {
                sum += number;
            }
            count += 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}