import java.util.*;
import java.io.*;

public class Solution{

    static int DIRECTIONS[][] = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}};

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int T, board[][] = new int[4][4];
        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase <= T; testcase++){
            for(int i = 0; i<4; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j = 0; j<4; j++){
                    board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            bufferedWriter.append("#"+testcase+" "+getOtherNumberCount(board)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int getOtherNumberCount(int board[][]){
        Set<Integer> integerSet = new HashSet<>();
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                pushNumber(board, i, j, 0, 1, integerSet);
            }
        }
        return integerSet.size();
    }

    static void pushNumber(int board[][], int x, int y, int value, int count,Set<Integer> integerSet){
        int nextX, nextY;
        if(count == 8){
            integerSet.add(value);
            return;
        }
        if(!((0 <= x && x < 4) && (0 <= y && y < 4))){
            return;
        }
        for(int direction[] : DIRECTIONS){
            nextX = x+direction[0];
            nextY = y+direction[1];
            pushNumber(board, nextX, nextY, value*10+board[x][y], count+1, integerSet);
        }
    }
}
