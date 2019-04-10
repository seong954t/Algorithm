import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            String X = st.nextToken();
            int sum = 0;

            for(int i =0 ; i < X.length(); i++){
                sum += X.charAt(i)-'0';
            }

            int answer = sum%(N-1);

            bw.write("#"+t + " " + answer + "\n");

        }

        bw.flush();
        bw.close();



    }
}
