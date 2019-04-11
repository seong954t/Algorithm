import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            String[] info = br.readLine().split(" ");
            int N = Integer.parseInt(info[0]);
            int M = Integer.parseInt(info[1]);
            int maxCount = 0;
            StringBuilder result = new StringBuilder();

            int[] count = new int[N + M + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    count[i + j]++;
                }
            }

            for (int i = 2; i < N + M + 1; i++) {
                if (maxCount < count[i]) {
                    maxCount = count[i];
                    result = new StringBuilder();
                    result.append(" ").append(i);
                } else if (maxCount == count[i]) {
                    result.append(" ").append(i);
                }
            }

            bw.write("#" + tc + result + "\n");
        }
        bw.flush();
        bw.close();
    }
}