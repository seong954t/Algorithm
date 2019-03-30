import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution{
    static boolean map[][];
    static int N, M;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            String temp[] = br.readLine().split(" ");
            N = Integer.parseInt(temp[0]);
            M = Integer.parseInt(temp[1]);

            map = new boolean[N][M];
            int beanCount =0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(!map[i][j]){
                        beanCount++;
                        map[i][j] = true;
                        beanCheck(i, j);
                    }
                }
            }
            System.out.println("#"+tc+" "+beanCount);

        }
        br.close();

    }
        // 콩을 못 심는 조건 -> 1. x 축 2차이, y축 동일 2. y 축 2차이, x축 동일 
        //  그러니 콩 하나 심었으면 못심는 조건인 곳 다 체그해둬야함
    public static void beanCheck(int i, int j){
           
           if(i-2 >=0 && !(map[i-2][j]))
                map[i-2][j] = true;

            if(i+2 <N && !(map[i+2][j]))
                map[i+2][j] = true;

            if(j-2 >=0 && !(map[i][j-2]))
                map[i][j-2] = true;

            if(j+2 <M && !(map[i][j+2]))
                map[i][j+2] = true;
            
        }
}
