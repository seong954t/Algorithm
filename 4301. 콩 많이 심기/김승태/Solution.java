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
            bufferedWriter.write("#"+testcase+" "+getBeanNum(N, M)+"\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int getBeanNum(int N, int M){
        int topBeanNum = getTopBeanNum(N);
        int nextBeanNum = getTopBeanNum(N - 2);
        int remainBeanNum[] = {0, topBeanNum, topBeanNum * 2, topBeanNum * 2 + nextBeanNum};
        int remainder = M % 4;
        int answer = topBeanNum * ((M - remainder) / 2) + nextBeanNum * ((M - remainder) / 2);

        return answer + remainBeanNum[remainder];
    }

    static int getTopBeanNum(int N){
        if(N < 0){
            return 0;
        }
        int remain = N % 4;
        remain = remain < 3 ? remain : 2;
        return (N / 4) * 2 + remain;
    }
}
