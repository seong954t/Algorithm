import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int T = 10, length;
        String input;
        for(int testcase = 1; testcase <= T; testcase++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            length = Integer.parseInt(stringTokenizer.nextToken());
            input = stringTokenizer.nextToken();
            for(int i = 0; i<length/2; i++){
                input = input.replaceAll("00|11|22|33|44|55|66|77|88|99", "");
            }
            bufferedWriter.write("#"+testcase+" "+input+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
