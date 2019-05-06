import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= 10; t++) {
            String garbage = br.readLine();

            char[] charArray = br.readLine().toCharArray();

            int solution = 0;
            for (int i = 0; i < charArray.length; i = i + 2) {
                solution += charArray[i] - '0';
            }
            bw.write("#" + t+" ");
            bw.write(solution + "\n");
        }
        bw.flush();
        bw.close();
    }
}
