import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T, N, answer, titleSeq[];

        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase<=T; testcase++){
            titleSeq = new int[26];
            answer = 26;
            N = Integer.parseInt(bufferedReader.readLine());
            for(int i = 0; i<N; i++){
                titleSeq[bufferedReader.readLine().charAt(0) - 65]++;
            }

            for (int i = 0; i < 26; i++) {
                if (titleSeq[i] == 0) {
                    answer = i;
                    break;
                }
            }

            bufferedWriter.write("#"+testcase+" "+answer+"\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
