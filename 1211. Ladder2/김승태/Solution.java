import java.io.*;
import java.util.*;

public class Solution {
    static int DOWN = 0;
    static int LEFT = 1;
    static int RIGHT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int T;
        char ladder[][] = new char[100][100];
        for (int testcase = 1; testcase <= 10; testcase++) {
            T = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < 100; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = stringTokenizer.nextToken().charAt(0);
                }
            }
            bufferedWriter.write("#" + T + " " + getMaxPosition(ladder) + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int getMaxPosition(char ladder[][]) {
        int position = 0;
        int minLength = 10000, tempLength;
        for (int i = 0; i < 100; i++) {
            if(ladder[0][i] == '1') {
                tempLength = getLength(ladder, i);
                if (tempLength < minLength) {
                    minLength = tempLength;
                    position = i;
                }
            }
        }

        return position;
    }

    static int getLength(char ladder[][], int start) {
        int x = start, y = 0, length = 1, direction = DOWN;

        while(y != 100){
            if(x+1 < 100 && ladder[y][x+1] == '1' && direction != LEFT){
                direction = RIGHT;
                x++;
            } else if(x-1 >= 0 &&ladder[y][x-1] == '1' && direction != RIGHT){
                direction = LEFT;
                x--;
            } else{
                direction = DOWN;
                y++;
            }
            length++;
        }
        return length;
    }
}
