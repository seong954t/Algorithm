import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {

    static int NO_PIPE_ARRAY[][] = {{0, 0}};
    static int UP_DOWN_LEFT_RIGHT_ARRAY[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int UP_DOWN_ARRAY[][] = {{1, 0}, {-1, 0}};
    static int LEFT_RIGHT_ARRAY[][] = {{0, 1}, {0, -1}};
    static int UP_RIGHT_ARRAY[][] = {{-1, 0}, {0, 1}};
    static int DOWN_RIGHT_ARRAY[][] = {{1, 0}, {0, 1}};
    static int DOWN_LEFT_ARRAY[][] = {{1, 0}, {0, -1}};
    static int UP_LEFT_ARRAY[][] = {{-1, 0}, {0, -1}};
    static int DIRECTION_ARRAY[][][] = {NO_PIPE_ARRAY, UP_DOWN_LEFT_RIGHT_ARRAY, UP_DOWN_ARRAY, LEFT_RIGHT_ARRAY, UP_RIGHT_ARRAY, DOWN_RIGHT_ARRAY, DOWN_LEFT_ARRAY, UP_LEFT_ARRAY};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int T, N, M, R, C, L, tunner[][] = new int[50][50];
        boolean visited[][] = new boolean[50][50];

        T = Integer.parseInt(bufferedReader.readLine());

        for(int testcase = 1; testcase <= T; testcase++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            M = Integer.parseInt(stringTokenizer.nextToken());
            R = Integer.parseInt(stringTokenizer.nextToken());
            C = Integer.parseInt(stringTokenizer.nextToken());
            L = Integer.parseInt(stringTokenizer.nextToken());
            for(int i = 0; i<N; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j = 0; j<M; j++){
                    tunner[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                    visited[i][j] = false;
                }
            }
            bufferedWriter.append("#"+testcase+" "+getMaxPosition(tunner, visited, N, M, R, C, L)+"\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int getMaxPosition(int tunner[][], boolean visited[][], int N, int M, int R, int C, int L){
        Queue<Point> pointQueue = new ArrayDeque<>();
        Queue<Integer> pointHourQueue = new ArrayDeque<>();
        pointQueue.add(new Point(R, C));
        pointHourQueue.add(1);
        Point currentPoint;
        int maxPosition = 0, currentPipe, currentHour, nextR, nextC;
        while (!pointQueue.isEmpty()){
            currentPoint = pointQueue.poll();
            currentHour = pointHourQueue.poll();
            R = currentPoint.x;
            C = currentPoint.y;
            if(currentHour > L){
                continue;
            }
            if(visited[R][C]){
                continue;
            }
            currentPipe = tunner[R][C];
            visited[R][C] = true;
            maxPosition++;
            for(int directions[] : DIRECTION_ARRAY[currentPipe]){
                nextR = R+directions[0];
                nextC = C+directions[1];
                if(((0 <= nextR && nextR < N) && (0 <= nextC && nextC < M))) {
                    for(int nextDirections[] : DIRECTION_ARRAY[tunner[nextR][nextC]]){
                        if(directions[0] == -nextDirections[0] && directions[1] == -nextDirections[1]){
                            pointQueue.add(new Point(nextR, nextC));
                            pointHourQueue.add(currentHour + 1);
                        }
                    }

                }
            }
        }
        return maxPosition;
    }
}
