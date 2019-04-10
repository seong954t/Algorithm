import java.io.*;
import java.util.StringTokenizer;

/*
 *  N, M(4 ≤ N, M ≤ 20)
 *
 * */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int sumNM = N + M;
            int[] numberOfKinds = new int[sumNM];
            for (int i = 0; i < sumNM; i++) {
                numberOfKinds[i] = calculateKinds(N, M, i);
            }

            int max = maxOfArray(numberOfKinds);


            bw.write("#" + t + " ");
            for (int i = 0; i < numberOfKinds.length; i++) {
                if (max == numberOfKinds[i]) {
                    bw.write(i + " ");

                }
            }
            bw.write("\n");


        }
        bw.flush();
        bw.close();
    }

    private static int maxOfArray(int[] kindsArray) {
        int max = -1;
        for (int i = 0; i < kindsArray.length; i++) {
            if (max <= kindsArray[i]) {
                max = kindsArray[i];
            }
        }


        return max;
    }

    private static int calculateKinds(int N, int M, int sum) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (j + i == sum) {
                    count++;
                }
            }
        }

        return count;
    }
}
