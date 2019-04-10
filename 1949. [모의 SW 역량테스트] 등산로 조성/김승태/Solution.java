import java.io.*;
import java.util.*;

public class Solution {

    static int UP[] = {-1, 0};
    static int RIGHT[] = {0, 1};
    static int DOWN[] = {1, 0};
    static int LEFT[] = {0, -1};
    static int DIRECTIONS[][] = {UP, RIGHT, DOWN, LEFT};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int T, K, N, MAX, TOP[][] = new int[20][20];
        boolean VISITED[][] = new boolean[20][20];
        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase<=T; testcase++){
            MAX = 0;
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            K = Integer.parseInt(stringTokenizer.nextToken());
            for(int i = 0; i<N; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j = 0; j<N; j++){
                    TOP[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                    VISITED[i][j] = false;
                    if(MAX < TOP[i][j]){
                        MAX = TOP[i][j];
                    }
                }
            }
            bufferedWriter.append("#"+testcase+" "+getMaxWayLength(N, K, MAX, TOP, VISITED)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int getMaxWayLength(int N, int K, int MAX, int TOP[][], boolean VISITED[][]){
        int answer = 0, temp;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(TOP[i][j] == MAX){
                    VISITED[i][j] = true;
                    temp = getMaxWayLength(i, j, N, K, TOP, VISITED);
                    VISITED[i][j] = false;
                    answer = max(answer, temp);
                }
            }
        }
        return answer;
    }

    static int getMaxWayLength(int i, int j, int N, int K, int TOP[][], boolean VISITED[][]){
        int nextI, nextJ, length = 1, temp, prevTop;
        for(int direction[] : DIRECTIONS){
            nextI = i+direction[0];
            nextJ = j+direction[1];
            if(((0 <= nextI && nextI < N) && (0 <= nextJ && nextJ < N)) && !VISITED[nextI][nextJ]){
                VISITED[nextI][nextJ] = true;
                if(TOP[nextI][nextJ] < TOP[i][j]){
                    temp = getMaxWayLength(nextI, nextJ, N, K, TOP, VISITED);
                    length = max(length, temp + 1);
                } else if(TOP[nextI][nextJ] - K < TOP[i][j]){
                    prevTop = TOP[nextI][nextJ];
                    TOP[nextI][nextJ] = TOP[i][j] - 1;
                    temp = getMaxWayLength(nextI, nextJ, N, 0, TOP, VISITED);
                    length = max(length, temp + 1);
                    TOP[nextI][nextJ] = prevTop;
                } else {
                    length = max(length, 1);
                }
                VISITED[nextI][nextJ] = false;
            }
        }
        return length;
    }

    static int max(int a, int b){
        return a < b ? b : a;
    }
}
