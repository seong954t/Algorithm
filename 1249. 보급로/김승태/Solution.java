import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int DIRECTIONS[][] = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int T, N, road[][], roadPoint[][];
        String rowRoad;
        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase<=T; testcase++){
            N = Integer.parseInt(bufferedReader.readLine());
            road = new int[N][N];
            roadPoint = new int[N][N];

            for(int i = 0; i<N; i++){
                rowRoad = bufferedReader.readLine();
                for(int j = 0; j<N; j++){
                    road[i][j] = Integer.parseInt(String.valueOf(rowRoad.charAt(j)));
                }
            }

            bufferedWriter.write("#"+testcase+" "+getRoadValue(road, roadPoint, N)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int getRoadValue(int road[][], int roadPoint[][], int N){
        Queue<Point> positionQueue = new LinkedList<>();
        positionQueue.add(new Point(0, 0));
        Point position;
        int nextX, nextY, nextRoadValue;
        roadPoint[0][0] = 1;
        while (!positionQueue.isEmpty()){
            position = positionQueue.poll();
            for(int direction[] : DIRECTIONS){
                nextX = position.x + direction[0];
                nextY = position.y + direction[1];
                if((nextX > -1 && nextX < N) && (nextY > -1 && nextY < N)){
                    nextRoadValue = roadPoint[position.x][position.y] + road[nextX][nextY];
                    if(roadPoint[nextX][nextY] == 0 || roadPoint[nextX][nextY] > nextRoadValue){
                        roadPoint[nextX][nextY] = nextRoadValue;
                        positionQueue.add(new Point(nextX, nextY));
                    }
                }
            }
        }
        return roadPoint[N-1][N-1] - 1;
    }
}
