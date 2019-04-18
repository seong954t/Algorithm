import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int T, N, P, moc, remainder;
        long answer;
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            P = Integer.parseInt(stringTokenizer.nextToken());
            moc = N / P;
            remainder = N % P;
            answer = (long) Math.pow(moc, P - remainder);
            answer *= (long) Math.pow(moc + 1, remainder);
            bufferedWriter.write("#" + testcase + " " + answer + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
