import java.io.*;
import java.util.*;

public class Solution {
    static int[][] map = new int[100][100];
    static int result = -1;
    static int N = 0;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int[][] block = {
            {1, 3, 0, 2},
            {3, 0, 1, 2},
            {2, 0, 3, 1},
            {1, 2, 3, 0},
            {1, 0, 3, 2}};
    static int[][] wormhole = new int[5][2];
    static List<Integer> startPoint = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            initGame();
            N = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                int j = 0;
                while (st.hasMoreTokens()){
                    int current = Integer.parseInt(st.nextToken());
                    map[i][j] = current;
                    if (current == 0) startPoint.add(i*1000 + j);
                    else if (current >= 6 && current <= 10) {
                        if (wormhole[current-6][0] == 0) {
                            wormhole[current-6][0] = i*1000 + j;
                        } else {
                            wormhole[current-6][1] = i*1000 + j;
                        }
                    }
                    j++;
                }
            }
            
            for (int start : startPoint) { // 핀볼 출발 위치
                for (int dir = 0; dir < 4; dir++) { // 상:0 하:1 좌:2 우:3
                    result = Math.max(playGame(start/1000, start%1000, dir), result);
                }
            }

            bw.append("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }

    static int playGame(int i, int j, int dir){
        int score = 0;
        int ci = i + di[dir];
        int cj = j + dj[dir];
        int cd = dir;

        while (true) {
            // 벽에 부딪힌 경우
            if (ci < 0 || cj < 0 || ci >= N || cj >= N) {
                if (cd == 0) cd = 1;
                else if (cd == 1) cd = 0;
                else if (cd == 2) cd = 3;
                else cd = 2;

                ci = ci + di[cd];
                cj = cj + dj[cd];
                score++;
                continue;
            }

            // 종료 조건
            if (map[ci][cj] == -1 || (ci == i && cj == j)) return score;

            // 빈칸인 경우
            if (map[ci][cj] == 0) {
                ci = ci + di[cd];
                cj = cj + dj[cd];
                continue;
            }

            // 블록인 경우
            if (map[ci][cj] >= 1 && map[ci][cj] <= 5) {
                cd = block[map[ci][cj]-1][cd]; // 방향 바꾸기

                ci = ci + di[cd];
                cj = cj + dj[cd];
                score++;
                continue;
            }

            // 웜홀인 경우
            if (map[ci][cj] >= 6 && map[ci][cj] <= 10) {
                int next = wormhole[map[ci][cj]-6][0];
                int ni = next/1000;
                int nj = next%1000;
                if (ni == ci && nj == cj) {
                    ni = wormhole[map[ci][cj]-6][1] / 1000;
                    nj = wormhole[map[ci][cj]-6][1] % 1000;
                }
                ci = ni + di[cd];
                cj = nj + dj[cd];
            }
        }

    }

    static void initGame(){
        result = -1;
        startPoint.clear();
        for (int i = 0; i < 5; i++){
            wormhole[i][0] = 0;
            wormhole[i][1] = 0;
        }
    }
}
