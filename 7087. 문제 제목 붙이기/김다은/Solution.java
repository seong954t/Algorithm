import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] count = new int[26];

            for (int n = 0; n < N; n++) {
                char firstChar = br.readLine().charAt(0);
                count[firstChar - 65]++;
            }

            int i = 0;

            while (i < 26 && count[i] > 0) {
                i++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#");
            sb.append(t+1);
            sb.append(" ");
            sb.append(i);
            System.out.println(sb);
        }
    }
}