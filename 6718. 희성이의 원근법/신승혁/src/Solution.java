import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            long N = Long.parseLong(br.readLine());
            int solution = perspective(N);
            bw.write("#" + t + " ");
            bw.write(solution + " ");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static int perspective(long N) {
        if (N < 100) {
            return 0;
        } else if (N < 1000) {
            return 1;
        } else if (N < 10000) {
            return 2;
        } else if (N < 100000) {
            return 3;
        } else if (N < 1000000) {
            return 4;
        } else {
            return 5;
        }
    }
}
