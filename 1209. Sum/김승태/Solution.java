import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int T, array[][] = new int[100][100];
        for(int testcase = 1; testcase<=10; testcase++){
            T = Integer.parseInt(bufferedReader.readLine());
            for(int i = 0; i<100; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j = 0; j<100; j++){
                    array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            bufferedWriter.write("#"+T+" "+getMaxValue(array)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int getMaxValue(int array[][]){
        int col, row, rightDiagonal = 0, leftDiagonal = 0, answer = 0;
        for(int i = 0; i<100; i++){
            col = 0;
            row = 0;
            for(int j = 0; j<100; j++){
                row += array[j][i];
                col += array[i][j];
            }
            rightDiagonal += array[i][i];
            leftDiagonal += array[99-i][i];
            answer = max(max(col, row), answer);
        }
        answer = max(max(rightDiagonal, leftDiagonal), answer);
        return answer;
    }

    static int max(int x, int y){
        return x < y ? y : x;
    }
}
