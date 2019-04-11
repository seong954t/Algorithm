import java.io.*;
import java.util.*;

public class Solution {
    static int n, k, answer;
    static int[][] map;
    static boolean[][] visited;
    static int di[] = {-1, 1, 0, 0};
    static int dj[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            visited = new boolean[n][n];
            int max = -1;
            Queue<Integer> maxQueue = new LinkedList<>();

            int j;
            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                j = 0;
                while (st.hasMoreTokens()) {
                    int current = Integer.parseInt(st.nextToken());
                    map[i][j] = current;

                    if (current > max) {
                        maxQueue.clear();
                        max = current;
                        maxQueue.add(i*100 + j);
                    } else if (current == max) {
                        maxQueue.add(i*100 + j);
                    }
                    j++;
                }
            }
            int size = maxQueue.size();
            for (int i = 0; i < size; i++) {
                int current = maxQueue.poll();
                dfs(current/100, current%100, 1, false);
            }
            bw.append("#" + t + " " + answer + "\n");
            bw.flush();
            answer = 0;
        }
        bw.close();
    }

    static void dfs(int i, int j, int len, boolean flag) {
        answer = Math.max(answer, len);
        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni < 0 || ni >= n || nj < 0 || nj >=n || visited[ni][nj]) continue;
            if (map[i][j] > map[ni][nj]) {
                dfs(ni, nj, len+1, flag);
            } else if (!flag && map[i][j] > map[ni][nj] - k) {
                int temp = map[ni][nj];
                map[ni][nj] = map[i][j] - 1;
                dfs(ni, nj, len+1, true);
                map[ni][nj] = temp;
            }
        }
        visited[i][j] = false;
    }
}