import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {

    static int UP[] = {1, 0};
    static int RIGHT_UP[] = {1, 1};
    static int RIGHT[] = {0, 1};
    static int RIGHT_DOWN[] = {-1, 1};
    static int DOWN[] = {-1, 0};
    static int LEFT_DOWN[] = {-1, -1};
    static int LEFT[] = {0, -1};
    static int LEFT_UP[] = {1, -1};

    static int DIRECTIONS[][] = {UP, RIGHT_UP, RIGHT, RIGHT_DOWN, DOWN, LEFT_DOWN, LEFT, LEFT_UP};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T, N;
        char mine[][] = new char[300][300];

        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase<=T; testcase++){
            N = Integer.parseInt(bufferedReader.readLine());
            for(int i = 0; i<N; i++){
                mine[i] = bufferedReader.readLine().toCharArray();
            }
            bufferedWriter.write("#"+testcase+" "+getMinimumClickCount(N, mine)+"\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int getMinimumClickCount(int N, char mine[][]){
        int aroundMineNum, minimumCount = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(mine[i][j] == '.') {
                    aroundMineNum = getAroundMineNum(N, mine, i, j);
                    if (aroundMineNum == 0) {
                        minimumCount++;
                        mine[i][j] = Character.forDigit(aroundMineNum, 10);
                        splashMineCount(N, mine, i, j);
                    }
                }
            }
        }
        
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(mine[i][j] == '.'){
                    minimumCount++;
                }
            }
        }
        return minimumCount;
    }

    static void splashMineCount(int N, char[][] mine, int i, int j) {
        Queue<Point> pointQueue = new ArrayDeque<>();
        pointQueue.add(new Point(i, j));
        Point point;
        int nextX;
        int nextY;
        int aroundMineNum;
        while(!pointQueue.isEmpty()){
            point = pointQueue.poll();
            for(int direction[] : DIRECTIONS){
                nextX = point.x+direction[0];
                nextY = point.y+direction[1];
                if((0 <= nextX && nextX < N) && (0 <= nextY && nextY < N)){
                    aroundMineNum = getAroundMineNum(N, mine, nextX, nextY);
                    if(aroundMineNum == 0 && mine[nextX][nextY] == '.'){
                        pointQueue.add(new Point(nextX, nextY));
                    }
                    mine[nextX][nextY] = Character.forDigit(aroundMineNum, 10);
                }
            }
        }
    }

    static int getAroundMineNum(int N, char mine[][], int x, int y){
        int nextX, nextY, mineNum = 0;
        for(int direction[] : DIRECTIONS){
            nextX = x+direction[0];
            nextY = y+direction[1];
            if((0 <= nextX && nextX < N) && (0 <= nextY && nextY < N)){
                if(mine[nextX][nextY] == '*'){
                    mineNum++;
                }
            }
        }
        return mineNum;
    }
}
