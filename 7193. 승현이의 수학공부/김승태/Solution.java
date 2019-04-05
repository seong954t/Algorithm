import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int T;
        String N, X;
        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase<=T; testcase++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            N = stringTokenizer.nextToken();
            X = stringTokenizer.nextToken();
            bufferedWriter.append("#"+testcase+" "+getMod(N, X)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int getMod(String N, String X){
        int n = Integer.parseInt(N), sum = 0;
        for(char value : X.toCharArray()){
            sum += value - 48;
        }
        return sum % (n-1);
    }
}
