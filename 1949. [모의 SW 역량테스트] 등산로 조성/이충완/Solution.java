import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static int result;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static List<Point> maxList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int top = 1;
            result = 1;
            maxList = new LinkedList<>();
            String[] info = br.readLine().split(" ");
            int N = Integer.parseInt(info[0]);
            int K = Integer.parseInt(info[1]);
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                    if (top < map[i][j]) {
                        top = map[i][j];
                        maxList.removeAll(maxList);
                        maxList.add(new Point(i, j));
                    } else if (top == map[i][j]) {
                        maxList.add(new Point(i, j));
                    }
                }

            }

            for (int i = 0; i < maxList.size(); i++) {
                Point point = maxList.get(i);
                int[][] copyMap = map.clone();
                boolean[][] visited = new boolean[N][N];
                dfs(point.x, point.y, K, 1, false, copyMap, visited);
            }
            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y, int k, int count, boolean isCutting, int[][] map, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < map.length && nextY >= 0 && nextY < map.length && !visited[nextX][nextY]) {
                if (map[nextX][nextY] < map[x][y]) {
                    // 현재 보다 낮아서 갈 수 있는 경우
                    dfs(nextX, nextY, k, count + 1, isCutting, map, visited);
                } else {
                    if (!isCutting) {
                        // 그동안 짜른적이 없어야됨
                        // 현재 보다 같거나 높은경우 깍아야됨!!
                        if (map[nextX][nextY] - (map[x][y] - 1) <= k) {
                            // 다음 갈 부분을 현재 내위치보다 1 낮게 할 수 있는지 확인
                            int temp = map[nextX][nextY];
                            map[nextX][nextY] = map[x][y] - 1;
                            dfs(nextX, nextY, k, count + 1, true, map, visited);
                            map[nextX][nextY] = temp;
                        } else {
                            // 못 깍음... 끝난겨...
                            if (result < count)
                                result = count;
                        }
                    } else {
                        // 끝나는 경우...
                        if (result < count)
                            result = count;
                    }
                }
            }
        }
        visited[x][y] = false;
    }
}
