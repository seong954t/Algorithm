import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int T,C, R, O, A, K;
        String input;

        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase<=T; testcase++){
            input = bufferedReader.readLine();
            bufferedWriter.append("#"+testcase+" "+getCroakCount(input)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int getCroakCount(String input){
        int C = 0, R = 0, O = 0, A = 0, K = 0, answer = 1;
        for(char c : input.toCharArray()){
            switch (c){
                case 'c':
                    if(K <= C){
                        C++;
                    }else {
                        return -1;
                    }
                    break;
                case 'r':
                    if(R < C && O <= R){
                        R++;
                    }else{
                        return -1;
                    }
                    break;
                case 'o':
                    if(O < R && A <= O){
                        O++;
                    }else{
                        return -1;
                    }
                    break;
                case 'a':
                    if(A < O && K <= A){
                        A++;
                    }else {
                        return -1;
                    }
                    break;
                case 'k':
                    if(K < C){
                        K++;
                        if(C != K){
                            answer = answer < C - K + 1 ? C - K + 1 : answer;
                        }
                    }else{
                        return -1;
                    }
                    break;
            }
        }
        if(C == R && R == O && O == A && A == K){
            return answer;
        }else{
            return -1;
        }
    }
}
