import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        int T, answer;
        T = 10;
        for (int testcase = 1; testcase <= T; testcase++) {
            answer = 0;
            bufferedReader.readLine();
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), "+");
            while(stringTokenizer.hasMoreTokens()){
                answer += Integer.parseInt(stringTokenizer.nextToken());
            }

            bufferedWriter.append("#"+testcase+" "+answer+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
