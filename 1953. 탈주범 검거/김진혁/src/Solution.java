import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            isVisited = new boolean[N][M];
            time = new int[N][M];

            for(int n = 0; n < N; n++){
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < M; m++){
                    map[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write("#"+t + " " + bfs(new Point(R,C), L, N, M) + "\n");



        }

        bw.flush();
        bw.close();





    }

    private static int bfs(Point point, int l, int n, int m) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        time[point.x][point.y] = 1;

        while(!queue.isEmpty()){
            Point pt = queue.poll();
            isVisited[pt.x][pt.y] = true;


            int[][] direction = directionSearch(map[pt.x][pt.y]);

            for (int[] aDirection : direction) {
                int x = pt.x + aDirection[0];
                int y = pt.y + aDirection[1];

                if (x >= 0 && y >= 0 && x < n && y < m) {

                    if (!isVisited[x][y] && map[x][y] != 0) {

                        int[][] connectCheck = directionSearch(map[x][y]);

                        for (int[] aConnectCheck : connectCheck) {

                            if (aDirection[0] == -aConnectCheck[0] &&  aDirection[1] == -aConnectCheck[1]) {
                                queue.add(new Point(x, y));
                                time[x][y] = time[pt.x][pt.y] + 1;
                                break;
                            }

                        }
                    }
                }
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j =0; j < m; j++){
                if(time[i][j] != 0 && time[i][j] <= l){
                    count++;
                }
            }
        }


        return count;
    }

    private static int[][] directionSearch(int i) {
        int[][] direct;
        switch(i){
            case 1:
                direct = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                break;
            case 2:
                direct = new int[][]{{1, 0}, {-1, 0}};
                break;
            case 3:
                direct = new int[][]{{0, 1}, {0, -1}};
                break;
            case 4:
                direct = new int[][]{{-1, 0}, {0, 1}};
                break;
            case 5:
                direct = new int[][]{{1, 0}, {0, 1}};
                break;
            case 6:
                direct = new int[][]{{1, 0}, {0, -1}};
                break;
            case 7:
                direct = new int[][]{{-1, 0}, {0, -1}};
                break;

                default:
                    direct = new int[0][0];
        }

        return direct;
    }
}
