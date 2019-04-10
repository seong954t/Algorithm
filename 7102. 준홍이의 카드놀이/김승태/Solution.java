import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int T, N, M;
        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase<=T; testcase++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            M = Integer.parseInt(stringTokenizer.nextToken());
            if(N < M){
                M = M + N;
                N = M - N;
                M = M - N;
            }
            bufferedWriter.append("#"+testcase);
            for(int i = 0; i < N - M + 1; i++){
                bufferedWriter.append(" "+(M + 1 + i));
            }
            bufferedWriter.append("\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
