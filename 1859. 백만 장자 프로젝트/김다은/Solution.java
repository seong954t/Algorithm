import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] intArray = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

            int maxIndex, left = 0;
            long result = 0;

            while (left < N) {
                maxIndex = getMaxIndex(left, N, intArray);
                if (maxIndex == 0) break;
                result += calculate(left, maxIndex, intArray[maxIndex], intArray);

                left = maxIndex+1;
            }

            bw.append("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }

    static int getMaxIndex(int left, int right, int[] intArray) {
        int max = -1;
        int maxIndex = 0;

        for (int i = left; i < right; i++) {
            if (max < intArray[i]) {
                max = intArray[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static long calculate(int left, int right, int max, int[] intArray) {
        long result = 0;
        for (int i = left; i < right; i++) {
            result = result + max - intArray[i];
        }
        return result;
    }
}
