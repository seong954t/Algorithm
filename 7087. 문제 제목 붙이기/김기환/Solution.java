import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {//7087_set the problem name
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
        int how_many = this.nextInt();
        for (int index_of_many = 0; index_of_many < how_many; ++index_of_many) {
            sb.append("#").append(index_of_many + 1).append(" ").append(do_times()).append("\n");
        }
        System.out.println(sb.toString());
    }

    private int do_times() {
        String[] title_of_books = new String[this.nextInt()];

        for (int index_of_input = 0; index_of_input < title_of_books.length; ++index_of_input) {
            title_of_books[index_of_input] = this.next();
        }
        Arrays.sort(title_of_books);
        int number_of_can_do = 0;
        for (int index_of_str = 0; index_of_str < title_of_books.length; ++index_of_str) {
            char firts_element = title_of_books[index_of_str].charAt(0);
            if (index_of_str == 0) {
                if (firts_element == 0x41) {
                    number_of_can_do += 1;
                } else {
                    break;
                }
            } else if (firts_element == (0x41 + number_of_can_do)) {
                number_of_can_do += 1;
            } else if (firts_element != (0x41 + number_of_can_do - 1) && firts_element != (0x41 + number_of_can_do)) {
                break;
            }
        }
        return number_of_can_do;
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
}