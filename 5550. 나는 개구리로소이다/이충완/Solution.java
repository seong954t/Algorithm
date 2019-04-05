import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            int c = 0, r = 0, o = 0, a = 0, k = 0, result = 0;
            char[] arr = br.readLine().toCharArray();
            for (char element : arr) {
                switch (element) {
                    case 'c':
                        c++;
                        break;
                    case 'r':
                        r++;
                        break;
                    case 'o':
                        o++;
                        break;
                    case 'a':
                        a++;
                        break;
                    case 'k':
                        k++;
                        break;
                    default:
                        break;
                }
                if(result < c)
                    result = c;
                if (k <= a && a <= o && o <= r && r <= c) {
                    if (k == 1) {
                        c--;
                        r--;
                        o--;
                        a--;
                        k--;
                    }
                } else {
                    break;
                }
            }
            if (c + r + o + a + k != 0)
                result = -1;
            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }
}
