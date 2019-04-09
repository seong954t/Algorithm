import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int d = Integer.parseInt(br.readLine());

            int answer;

            if (d < 100) {
                answer = 0;
            } else if (d < 1000) {
                answer = 1;
            } else if (d < 10000) {
                answer = 2;
            } else if (d < 100000) {
                answer = 3;
            } else if (d < 1000000) {
                answer = 4;
            } else {
                answer = 5;
            }

            bw.write("#" + t + " " + answer + "\n");

        }

        bw.flush();
        bw.close();


    }
}
