import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 100;
        for (int t = 0; t < 10; t++) {
            br.readLine();
            String[][] strArray = new String[size][size];
            int[][] intArray = new int[size][size];

            for (int i = 0; i < size; i++) {
                strArray[i] = br.readLine().split(" ");
                intArray[i] = Arrays.asList(strArray[i]).stream().mapToInt(Integer::parseInt).toArray();
            }

            int rowMax = -1, colMax = -1;
            int rowSum, colSum, leftDia = 0, rightDia = 0, result;

            for (int i = 0; i < size; i++){
                rowSum = 0;
                colSum = 0;
                for (int j = 0; j < size; j++){
                    rowSum += intArray[i][j];
                    colSum += intArray[j][i];
                }
                rowMax = Math.max(rowMax, rowSum);
                colMax = Math.max(colMax, colSum);
            }

            for (int i = 0; i < size; i++){
                leftDia += intArray[i][i];
                rightDia += intArray[size - 1 - i][i];
            }
            result = Collections.max(Arrays.asList(rowMax, colMax, leftDia, rightDia));

            StringBuilder sb = new StringBuilder();
            sb.append("#");
            sb.append(t+1);
            sb.append(" ");
            sb.append(result);
            System.out.println(sb);
        }
    }
}