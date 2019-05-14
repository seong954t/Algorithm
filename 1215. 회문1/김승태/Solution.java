import java.io.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10, N;
        char puzzle[][] = new char[8][8];
        for(int testcase = 1; testcase <= T; testcase++){
            N = Integer.parseInt(bufferedReader.readLine());
            for(int i = 0; i<8; i++){
                puzzle[i] = bufferedReader.readLine().toCharArray();
            }
            bufferedWriter.write("#"+testcase+" "+getCountOfPalindrome(puzzle, N)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int getCountOfPalindrome(char puzzle[][], int N){
        int answer = 0;
        for(int i = 0; i<8; i++){
            for(int j = 0; j<9-N; j++){
                answer += isVerticalPalindrome(puzzle, N, j, i);
                answer += isHorizenPalindrome(puzzle, N, i, j);
            }
        }
        return answer;
    }

    static int isVerticalPalindrome(char puzzle[][], int N, int x, int y){
        for(int i = 0; i<(N+1)/2; i++){
            if(puzzle[x+i][y] != puzzle[x+N-1-i][y]){
                return 0;
            }
        }
        return 1;
    }

    static int isHorizenPalindrome(char puzzle[][], int N, int x, int y){
        for(int i = 0; i<(N+1)/2; i++){
            if(puzzle[x][y+i] != puzzle[x][y+N-1-i]){
                return 0;
            }
        }
        return 1;
    }
}
