import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int count[] = new int[N*M + 1];

            int max = -1;
            List<Integer> maxList = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    count[i+j]++;
                    if (max < count[i+j]) {
                        max = count[i+j];
                        maxList.clear();
                        maxList.add(i+j);
                    } else if (max == count[i+j]) {
                        maxList.add(i+j);
                    }
                }
            }
            Collections.sort(maxList);
            System.out.print("#" + t);
            for (int i : maxList){
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
}