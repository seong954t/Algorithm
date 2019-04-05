import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

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


    private int doTimes() {
        int uppterNumber = this.nextInt();
        String number = this.next();
        BigInteger sum = new BigInteger("0");
        for (int strLenth = 0; strLenth < number.length(); ++strLenth) {
            sum = sum.add(new BigInteger(number.substring(strLenth, strLenth + 1)));
        }
        return Integer.parseInt(sum.mod(new BigInteger(Integer.toString(uppterNumber - 1))).toString());
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}