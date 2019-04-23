import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int quotient = N / P;
            int remainder = N % P;

            long result = (long) Math.pow(quotient, P-remainder);
            for (int i = 0; i < remainder; i++){
                result *= (quotient+1);
            }
            bw.append("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }
}