import java.io.*;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] sumCase = new int[41];

            for(int i = 1; i <= N; i++){
                for(int j = 1;j <= M; j++){
                    sumCase[i+j]++;
                }
            }

            bw.write("#" + t + " ");
            int maxNum = 0;
            for(int i = 1; i < sumCase.length; i++){
                if(maxNum < sumCase[i]){
                    maxNum = sumCase[i];
                }
            }

            for(int i = 1; i < sumCase.length; i++){
                if(sumCase[i] == maxNum ){
                    bw.write(i + " ");
                }
            }





            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }
}
