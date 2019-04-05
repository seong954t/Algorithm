import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T, N;
        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase<=T; testcase++){
            switch (bufferedReader.readLine().length()){
                case 1: case 2:
                    N = 0;
                    break;
                case 3:
                    N = 1;
                    break;
                case 4:
                    N = 2;
                    break;
                case 5:
                    N = 3;
                    break;
                case 6:
                    N = 4;
                    break;
                default:
                    N = 5;
                    break;
            }
            bufferedWriter.append("#"+testcase+" "+N+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
