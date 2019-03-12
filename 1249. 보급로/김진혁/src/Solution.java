import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int map[][];
    static int isVisited[][];
    static int mapSize;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            mapSize = Integer.parseInt(br.readLine());

            map = new int[mapSize][mapSize];
            isVisited = new int[mapSize][mapSize];

            for(int i = 0; i < mapSize; i++){
                String line = br.readLine();
                for(int j =0; j < mapSize; j++){
                    map[i][j] = Integer.parseInt(line.charAt(j)+"");
                }
            }

            for(int i = 0; i < mapSize; i++){
                for(int j =0; j < mapSize; j++){
                    isVisited[i][j] = -1;
                }
            }

//            Arrays.fill(isVisited, -1);
            isVisited[0][0] = 0;

            bw.write("#"+t+ " " + bfs() + "\n");
        }
        bw.flush();
        bw.close();

    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));

        while(!queue.isEmpty()){
            Point pt = queue.poll();

            for(int i =0; i <4; i++){
                int x = pt.x + dx[i];
                int y = pt.y + dy[i];

                if(x >= 0 && y >= 0 && x < mapSize && y < mapSize){
                    int nextValue = isVisited[pt.x][pt.y] + map[x][y];
                    if(isVisited[x][y] == -1 || nextValue < isVisited[x][y]){
                        isVisited[x][y] = nextValue;
                        queue.add(new Point(x, y));
                    }
                }


            }

        }


        return isVisited[mapSize-1][mapSize-1];
    }
}
