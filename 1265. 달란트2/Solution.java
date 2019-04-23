import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer parser = new StringTokenizer(br.readLine(), " ");
            long N = Long.parseLong(parser.nextToken());
            long P = Long.parseLong(parser.nextToken());
            long portion = N / P;
            long remain = N % P;
            long result = (long) Math.pow(portion + 1, remain) * (long) Math.pow(portion, P - remain);
            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }
}
