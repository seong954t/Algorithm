import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int result = br.readLine().length() - 2;
            if (result < 0) result = 0;
            if (result > 5) result = 5;
            bw.append("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }
}