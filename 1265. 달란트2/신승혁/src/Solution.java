import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[제약 사항]
원생이 모은 달란트의 수 N의 범위는 10 달란트 <= N <= 100 달란트이다.
묶음의 수 P는 P <= N로 주어진다.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            double solution = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int[] pArray = new int[P];
            Arrays.fill(pArray, N / P);
            int restNum = N % P;

            for (int i = 0; i < restNum; i++) {
                pArray[i]++;
            }

            solution = multiply(pArray);
            bw.write("#" + t + " ");
            bw.write(new DecimalFormat("###.#####").format(solution));

            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }

    private static double multiply(int[] pArray) {
        int size = pArray.length;
        double result = pArray[0];
        for (int i = 1; i < size; i++) {
            result *= pArray[i];
        }
        return result;
    }
}
