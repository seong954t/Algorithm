import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());   // N명
            int M = Integer.parseInt(st.nextToken());   // M개의 문제

            int[] score_array = new int[N];     // 배열 값에는 맞힌 개수가 들어감
            int max = -1;
            int count_max = 0;

            // 한 사람당 맞힌 문제수를 배열에 삽입
            for (int n = 0; n < N; n++) {
                int score = 0;
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    String score_token = st.nextToken();
                    if (score_token.equals("1")) {
                        score++;
                    }
                }
                score_array[n] = score; //  {2,3,1}  //  {4,4,4,4}  // {3,3,3,3}  //  {0}

                // 점수 중 가장 큰 값찾아서 그 값과 같은 값 나올때 counting
                if (max == score) {
                    count_max++;
                } else if (max < score) {
                    max = score;
                    count_max = 1;
                }
            }
            System.out.println("#" + t + " " + count_max + " " + max);
        }
    }
}
