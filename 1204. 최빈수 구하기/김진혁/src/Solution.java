import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            br.readLine();
            int[] score = new int[101];
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                score[Integer.parseInt(st.nextToken())]++;
            }

            int max = 0;
            int mode = 0;
            for (int i = 0; i < score.length; i++) {
                if (max <= score[i]) {
                    max = score[i];
                    mode = i;
                }
            }

            bw.write("#"+tc + " " + mode + "\n");

        }

        bw.flush();
        bw.close();

    }
}
