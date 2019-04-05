import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int T, N, boxWeight[] = new int[101];

        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase<=T; testcase++){
            N = Integer.parseInt(bufferedReader.readLine());
            for(int i = 0; i<N; i++){
                boxWeight[i] = Integer.parseInt(bufferedReader.readLine());
            }
            bufferedWriter.append("#"+testcase+" "+getMaxMoveCount(N, boxWeight)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int getMaxMoveCount(int N, int boxWeight[]){
        int answer = 0, moveBoxIndex = 0, moveBoxWeight;
        Arrays.sort(boxWeight, 0, N-1);
        for(int i = N-1; i >= 0; i--){
            moveBoxWeight = boxWeight[i];
            answer++;
            for(; moveBoxIndex < i; moveBoxIndex++){
                if(moveBoxWeight >= 50){
                    break;
                }
                moveBoxWeight += boxWeight[i];
            }
            if(moveBoxWeight < 50){
                answer--;
            }
            if(moveBoxIndex == i){
                break;
            }
        }
        return answer;
    }
}
