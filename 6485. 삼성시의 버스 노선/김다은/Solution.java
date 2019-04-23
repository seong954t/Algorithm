import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int[] busStop = new int[5001];

            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                for (int j = start; j <= end; j++) {
                    busStop[j]++;
                }
            }

            bw.append("#" + t + " ");
            int P = Integer.parseInt(br.readLine());
            for (int i = 0; i < P; i++) {
                int number = Integer.parseInt(br.readLine());
                bw.append(busStop[number] + " ");
            }
            bw.append("\n");
            bw.flush();
        }
        bw.close();
    }
}