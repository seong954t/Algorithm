import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char[] A = st.nextToken().toCharArray();
            char[] B = st.nextToken().toCharArray();

            int countIter = 0;
            for (int i = 0; i < A.length; i++) {
                char firstA = A[i];
                if (firstA == B[0]) {
                    for (int j = 0; j < B.length; j++) {
                        if (i + j >= A.length) {
                            break;
                        }
                        if (A[i + j] != B[j]) {
                            i = i + j;
                            break;
                        }
                        if (j == B.length - 1) {
                            countIter++;
                            i = i + j;
                        }
                    }
                }
            }
            int solution = A.length - (countIter * B.length) + countIter;
            bw.write("#" + t + " ");
            bw.write(solution + "\n");

        }
        bw.flush();
        bw.close();
    }
}
