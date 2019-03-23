import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class Solution {
    static int ladderMap[][];
    static int visited[][];
    static int dx[] = {-1, 1, 0};
    static int dy[] = {0, 0, 1};
    static int count;
    static boolean flag;
      
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for(int tc=0; tc<10; t++) {
            int T = Integer.parseInt(br.readLine());
            ladderMap = new int[100][100];
            for(int i=0; i<100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    ladderMap[i][j]=Integer.parseInt(st.nextToken());
                }
            }
 
            int min = Integer.MAX_VALUE, result = 0;
            for(int j=0; j<100; j++) {
                flag = false;
                findRoute(0, j);
                 
                if(flag==true) {
                    if(min>count) {
                        min=count;
                        result=j;
                    }           
                }   
            }
            System.out.println("#"+T+" "+result);
            }
        }
    public static void findRoute(int cury, int curx) {
        visited = new int[100][100];
        count=0;
        if(ladderMap[cury][curx]==0) {
            flag=false;
            return ;
        }
        for(int y=cury; y<100; y++) {
            for(int x=curx; x<100; x++) {
                if(visited[y][x]!=1 && ladderMap[y][x]==1) { 
                    cury = y;
                    curx = x;
                    visited[cury][curx]=1; 
                    count++;
                }
                for(int m=0; m<3; m++) {
                    if(cury+dy[m]<0 || cury+dy[m]>100-1 || curx+dx[m]<0 || curx+dx[m]>100-1) { 
                        continue;
                    }
                    if(visited[cury+dy[m]][curx+dx[m]]==1 || ladderMap[cury+dy[m]][curx+dx[m]]==0) { 
                        continue;
                    }
                    if(ladderMap[cury+dy[m]][curx+dx[m]]==1 || ladderMap[cury+dy[m]][curx+dx[m]]==2) {
                        cury += dy[m];
                        curx += dx[m];
                        visited[cury][curx]=1; 
                        count++;
                        y=cury;
                        x=curx-1;
                        break;
                    }           
                }       
                if(cury == 100-1 && ladderMap[cury][curx]==0) { 
                    flag = false;
                    return;
                }
                if(cury == 100-1 && ladderMap[cury][curx]==1) {
                    flag = true;
                    return;
                }       
            }
        }
    }
}
