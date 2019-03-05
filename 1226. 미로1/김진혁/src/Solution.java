import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int mapSize = 16;
    static boolean[][] isVisited = new boolean[mapSize][mapSize];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for(int t = 1; t <= 10; t++){
            br.readLine();
            char[][] map = new char[mapSize][mapSize];
            isVisited = new boolean[mapSize][mapSize];

            for(int i = 0; i < mapSize; i++){
                map[i] = br.readLine().toCharArray();
            }
            bw.write("#"+t + " " +solution(map) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int solution(char[][] map) {
        for(int i =0 ; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                if(map[i][j] == '2'){
                    Pointer point = new Pointer(i, j);
                    return bfs(map, point);
                }
            }
        }
        return 0;
    }

    private static int bfs(char[][] map, Pointer point) {
        Queue<Pointer> queue = new LinkedList<>();
        ((LinkedList<Pointer>) queue).add(point);
        isVisited[point.x][point.y] = true;

        while(!queue.isEmpty()){
            Pointer pt = queue.poll();

            for(int i = 0; i < 4; i++){
                int x = pt.x + dx[i];
                int y = pt.y + dy[i];

                if(x >= 0 && y >= 0 && x < mapSize && y < mapSize){
                    if(!isVisited[x][y]) {
                        if (map[x][y] == '3') {
                            return 1;
                        } else if (map[x][y] == '0') {
                            ((LinkedList<Pointer>) queue).add(new Pointer(x, y));
                            isVisited[x][y] = true;
                        }
                    }
                }
            }

        }
        return 0;
    }

    private static class Pointer {
        int x;
        int y;

        public Pointer(int i, int j) {
            x = i;
            y = j;
        }
    }
}
