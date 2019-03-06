import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution {
    static final int arrlength = 16;
    static int graph[][] = new int [16][16];
    static boolean visited[][];     
;    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number, result;
         
        for(int x=1; x<=10; x++){
            number = Integer.parseInt(br.readLine());
            visited = new boolean[16][16];
            for(int i=0; i<arrlength; i++){
                String line = br.readLine();
                for(int j=0; j<arrlength; j++){
                    graph[i][j] = Integer.parseInt(line.charAt(j)+"");              
                }
            }                
            //  시작지점 좌표를 넣어 미로 탐색을 시작한다.
            result = maze(1, 1) ? 1 : 0;
            System.out.println("#"+number+" "+result);    
        }         
        br.close();
    }
     
    //  성공 시 1, 실패 시 0
    public static boolean maze(int x, int y){
        if(x<0 || y<0 || x>=arrlength || y>=arrlength || visited[x][y] || graph[x][y] ==1)
            return false;
        //  출구를 찾으면 true 조건
        if(graph[x][y] == 3)
            return true;
        //  출구를 아직 찾지 못했을 때, 출구 찾기 위해 네 방향 체크
        else{
            visited[x][y] = true;   //  방문 배열 체크 
            if(maze(x-1,y)||maze(x+1,y)||maze(x,y-1)||maze(x,y+1))
                return true;
        }   
        return false;
    }
}
