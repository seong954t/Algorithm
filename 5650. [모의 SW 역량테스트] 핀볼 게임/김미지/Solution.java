import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
 
    static class Pos{
        static int y,x;
    }
    static int maxn = 115;
 
    static int [][]map = new int[maxn][maxn];
    static int [][]wprmholePos = new int[5][2];
 
    static int ans;
    static int N;
 
    final static int[] dy= new int[]{0,0,1,-1};
    final static int[] dx= new int[]{1,-1,0,0};
    final static int [][] chageDirection = new int[][]{
            {0,1,2,3},{1,3,0,2},{1,2,3,0},{2,0,3,1},{3,0,1,2},{1,0,3,2}
    };
 
    static void setUpTheWall(){
        for(int i=0; i<=N+1; i++){
            map[i][0] = map[i][N+1]=map[0][i]=map[N+1][i]=5;
        }
    }
    static void wormhole(Pos pos, int wormhole_n){
        for(int i=1; i<=N;i++){
            for(int j=1; j<=N;j++){
                if((pos.y!=i || pos.x!=j) && map[i][j] == wormhole_n){
                    pos.y=i; pos.x=j;
                    return;
                }
            }
        }
    }
    static void simulate(int sy, int sx,int d){
        Pos pos = new Pos();
        pos.y = sy;
        pos.x = sx;
        int cnt=0;
        while (true){
            pos.y=pos.y+dy[d];
            pos.x=pos.x+dx[d];
 
            //다음 좌표가 시작점 sy,sx 이거나 블랙홀 -1인 경우
            if((pos.x==sx && pos.y==sy)||map[pos.y][pos.x]==-1){
                if(ans<cnt) ans = cnt;
                return;
            }
            if(map[pos.y][pos.x]!=0){
                if(map[pos.y][pos.x]<6){ //블록
                    d=chageDirection[map[pos.y][pos.x]][d];
                    cnt++;
                }
                else { //웜홀
                    wormhole(pos, map[pos.y][pos.x]); //웜홀을 따로 저장해 속도를 줄일 수잇다
                    continue;
                }
            }
        }
    }
 
    static void solve(){
        ans =0;
        for(int i=1;i<=N; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j]!=0) continue;
                for(int d=0; d<4;d++){
                    simulate(i,j,d);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            N= sc.nextInt();
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            setUpTheWall();
            solve();
            System.out.printf("#%d %d\n",tc,ans );
        }
    }
 
}