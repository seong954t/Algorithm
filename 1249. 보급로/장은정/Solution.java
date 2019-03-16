import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.io.IOException;
 
class Node implements Comparable<Node>{
    int x,y;
    int depth;
     
    public Node(int x, int y, int depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
 
    //  priority queue 구현 
    @Override
    public int compareTo(Node node) {
        if(depth < node.depth)
            return -1;
        else
            return 1;
    }
}

public class Solution {
    static int N;
    static int[][] graph;
    static boolean visited[][];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
         
         
        for(int i=0; i<testcase; i++){
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];
            visited = new boolean[N][N];
            //  1. data 입력
            for(int j=0; j<N; j++){
                String line = br.readLine();
                for(int k=0; k<N; k++){
                    graph[j][k] = Integer.parseInt(String.valueOf(line.charAt(k)));
                }
            }
            //  2. 탐색
            bfs(i);
 
        }   
    }
     
    public static void bfs(int testcase){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        //  시작 좌표 설정
        pq.add(new Node(0,0,0));
        visited[0][0] = true;

        while(!pq.isEmpty()){
            Node temp = pq.poll();

            if(temp.x == N-1 && temp.y == N-1){
                System.out.println("#"+(testcase+1)+" "+temp.depth);
                break;
            }
             
            int x, y, depth;
            x = temp.x;
            y = temp.y;
            depth = temp.depth;

            for(int i=0; i<4; i++){
                x = temp.x+dx[i];
                y = temp.y+dy[i];
                depth = temp.depth;

                //(유효인덱스 && 방문하지 않았을 경우)
                if(x>=0 && y>=0 && x<N && y<N && visited[x][y]== false){
                    visited[x][y] = true;
                    pq.add(new Node(x, y, graph[x][y]+depth));
                }
            }

        }
    }
 
}
 
