import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int T;
        String A, B;

        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase<=T; testcase++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            A = stringTokenizer.nextToken();
            B = stringTokenizer.nextToken();
            bufferedWriter.append("#"+testcase+" "+A.replaceAll(B, "a").length()+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
