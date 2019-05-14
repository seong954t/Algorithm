import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = 8;

        for (int t = 1; t <= 10; t++) {
            String[][] input = new String[size][size];
            int result = 0;

            int palindromeLength = Integer.parseInt(br.readLine());
            for (int i = 0; i < size; i++) {
                input[i] = br.readLine().split("");
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int rowCheck = 1;
                    int colCheck = 1;

                    for (int k = 0; k < palindromeLength / 2; k++) {
                        if (j > size-palindromeLength || (input[i][j+k].compareTo(input[i][j-k+palindromeLength-1]) != 0)) rowCheck = 0;
                        if (i > size-palindromeLength || (input[i+k][j].compareTo(input[i-k+palindromeLength-1][j]) != 0)) colCheck = 0;
                    }
                    result += rowCheck;
                    result += colCheck;
                }
            }
            bw.append("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }
}
