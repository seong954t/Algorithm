import java.io.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10, testcase, originalLength, replaceLength;
        String regex, input;
        for(int i = 1; i <= T; i++){
            testcase = Integer.parseInt(bufferedReader.readLine());
            regex = bufferedReader.readLine();
            input = bufferedReader.readLine();
            originalLength = input.length();
            input = input.replaceAll(regex, "");
            replaceLength = input.length();
            bufferedWriter.write("#"+testcase+" "+(originalLength - replaceLength)/regex.length()+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
