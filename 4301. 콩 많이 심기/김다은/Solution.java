import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N=0, M=0;
            while (st.hasMoreTokens()) {
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
            }

            int result = N * M;
            int[][] map = new int[M][N];

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) {
                        if (i+2 < M && map[i+2][j] == 0){
                            map[i+2][j] = 1;
                            result--;
                        }
                        if (j+2 < N && map[i][j+2] == 0){
                            map[i][j+2] = 1;
                            result--;
                        }
                    }
                }
            }
            bw.append("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }
}