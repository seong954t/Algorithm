import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int scoreCounts[], T, testcase, maxScoreCount, answer;
        T = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0; i<T; i++){
            scoreCounts = new int[101];
            testcase = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while (stringTokenizer.hasMoreTokens()){
                scoreCounts[Integer.parseInt(stringTokenizer.nextToken())]++;
            }

            maxScoreCount = scoreCounts[0];
            answer = 0;

            for(int score = 0; score < 101; score++){
                if(maxScoreCount <= scoreCounts[score]){
                    maxScoreCount = scoreCounts[score];
                    answer = score;
                }
            }
            bufferedWriter.write("#"+testcase+" "+answer+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
