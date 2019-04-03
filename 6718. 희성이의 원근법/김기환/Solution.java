import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {//6718. 희성이의 원근법
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
        String numberstr = this.next();

        if (numberstr.length() > 6) {
            return 5;
        } else if (numberstr.length() > 2) {
            return numberstr.length() - 2;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}