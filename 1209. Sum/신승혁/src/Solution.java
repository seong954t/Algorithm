import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        final int T = 10;
        final int array_length = 100;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int t = 1; t <= T; t++) {
            int t_print = Integer.parseInt(br.readLine());
            // Build
            int[][] input_array = new int[array_length][array_length];
            for (int i = 0; i < array_length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < array_length; j++) {
                    input_array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] sum_array = new int[array_length * 2 + 2];// 행 100줄+ 열100줄 + 대각선 2줄
            // 1. index 0~99까지 100개의 행 더한것
            // 2. index 100~199까지 100개의 열 더한것
            // 3. 좌상 우하 대각선 [200]
            // 4. 우상 좌하 대각선 [201]

            // Sum
            for (int i = 0; i < array_length; i++) {
                for (int j = 0; j < array_length; j++) {
                    // 1
                    sum_array[i] += input_array[i][j];
                    // 2
                    sum_array[i + 100] += input_array[j][i];
                    // 3
                    if (i == j) {
                        sum_array[200] = input_array[i][j];
                    }
                    // 4
                    if (i == array_length - j) {
                        sum_array[201] = input_array[i][j];
                    }
                }
            }

            // Max
            int max = -1;
            for (int i = 0; i < sum_array.length; i++) {
                if (max < sum_array[i]) {
                    max = sum_array[i];
                }
            }


            bw.write("#" + t_print + " ");
            bw.write(max + " ");

            bw.write("\n");

        }


        bw.flush();
        bw.close();
    }
}
