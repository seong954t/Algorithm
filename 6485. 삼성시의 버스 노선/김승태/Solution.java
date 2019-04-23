import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int T, N, A, B, P, C;
        Point busStop[] = new Point[501];
        int answer[] = new int[501];
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(bufferedReader.readLine());
            for(int i = 0; i<N; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                A = Integer.parseInt(stringTokenizer.nextToken());
                B = Integer.parseInt(stringTokenizer.nextToken());
                busStop[i] = new Point(A, B);
                answer[i] = 0;
            }
            P = Integer.parseInt(bufferedReader.readLine());
            for(int i = 0; i<P; i++){
                C = Integer.parseInt(bufferedReader.readLine());
                for(int j = 0; j<N; j++){
                    if(busStop[j].x <= C && C <= busStop[j].y){
                        answer[i]++;
                    }
                }
            }
            bufferedWriter.write("#" + testcase + " " + toStringArray(answer, P) + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static String toStringArray(int array[], int P){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<P; i++){
            stringBuilder.append(array[i]+" ");
        }
        return stringBuilder.toString();
    }
}
