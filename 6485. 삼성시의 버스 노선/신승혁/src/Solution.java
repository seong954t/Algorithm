import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int solution = 0;
            int N = Integer.parseInt(br.readLine()); // 2
            int[] A = new int[N];
            int[] B = new int[N];
            for (int n = 0; n < N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                A[n] = Integer.parseInt(st.nextToken());
                B[n] = Integer.parseInt(st.nextToken());
            }

            int P = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int[] C = new int[P];
            // Build
            for (int p = 0; p < P; p++) {
                C[p] = Integer.parseInt(br.readLine());
                map.put(C[p], 0);
            }

            // Count
            for (int n = 0; n < N; n++) {
                for (int i = A[n]; i <= B[n]; i++) {
                    if (map.containsKey(i)) {
                        int value = map.remove(i);
                        value += 1;
                        map.put(i, value);
                    }
                }
            }


            bw.write("#" + t + " ");
            for (int i = 0; i < C.length; i++) {
                bw.write(map.get(C[i]) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
