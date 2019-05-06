import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result;
        for (int t = 1; t <= 10; t++) {
            result = 0;
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine(), "+");
            while (st.hasMoreTokens()){
                result += Integer.parseInt(st.nextToken());
            }
            bw.append("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }
}
