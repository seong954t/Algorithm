import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x, y;
    public Point(int x, int y){
            this.x = x;
            this.y = y;
        }     
}

public class Solution{
    public static int N, M, R, C, L;
    public static int map[][];
    public static int visited[][];
    public static int tunnel[][] = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 1, 0, 0 },
            { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 } };
    public static int dx[] = {-1,0,1,0};
    public static int dy[] = {0,1,0,-1};
    public static Queue<Point> q;
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
 
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
  
            //   N 세로크기, M 가로크기, R 맨홀세로, C 맨홀 가로, 소요시간 L
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken()); 
            L = Integer.parseInt(st.nextToken());
             
            map = new int[N][M];
            visited = new int[N][M];
            q= new LinkedList<>();
             
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = 0;
            visited[R][C] = 1;
            q.add(new Point(R, C));
             
            bfs();
             
            System.out.println("#" + (t+1) + " " + ans);
             
        }
 
    }
     
    private static void bfs() {
        int time = 1;
        while(true) {            
            ans+= q.size();
            if(time==L) {
                return;
            }         
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point location = q.poll();
                 
                for (int j = 0; j < 4; j++) {                     
                    int temp = map[location.i][location.j];
                     
                    if(tunnel[temp][j] == 0) {
                        continue;
                    }
                                          
                    int newx = location.i+dx[j];
                    int newy = location.j+dy[j];
                     
                    if(newx<0 || newx >= N || newy <0 || newy >= M)continue;
                     
                    if(map[newx][newy] == 0 || visited[newx][newy] == 1)continue;
                     
                    temp = map[newx][newy];
                     
                    if(tunnel[temp][(j+2)%4] == 1) {
                        visited[newx][newy] = 1;
                        q.add(new Point(newx, newy));
                    }
                }              
            }
            time++;             
        }
        
    }
 
}
