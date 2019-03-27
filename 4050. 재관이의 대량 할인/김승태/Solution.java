import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        int T, N, price[] = new int[100001];
        long answer;

        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase<=T; testcase++){
            answer = 0;
            N = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i = 0; i<N; i++){
                price[i] = Integer.parseInt(stringTokenizer.nextToken());
                answer += price[i];
            }
            Arrays.sort(price, 0, N);
            for(int i = 0; i<N/3; i++){
                answer -= price[N%3+i*3];
            }
            bufferedWriter.write("#"+testcase+" "+answer+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
