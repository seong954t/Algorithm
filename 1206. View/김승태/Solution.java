import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int N, building[] = new int[1001];
        for(int testcase = 1; testcase<=10; testcase++){
            N = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i = 0; i<N; i++){
                building[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            bufferedWriter.write("#"+testcase+" "+getViewValue(building, N)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int getViewValue(int building[], int N){
        int viewValue, answer = 0;
        for(int i = 2; i<N-2; i++){
            viewValue = max(max(building[i-2], building[i-1]), max(building[i+1], building[i+2]));
            viewValue = building[i] - viewValue;
            if(viewValue > 0){
                answer += viewValue;
            }
        }
        return answer;
    }

    static int max(int x, int y){
        return x < y ? y : x;
    }
}
