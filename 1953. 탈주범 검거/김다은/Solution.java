import java.io.*;
import java.util.*;

public class Solution {
    static int di[] = {-1, 1, 0, 0};
    static int dj[] = {0, 0, -1, 1};
    static int neighbor[] = {1, 0, 3, 2};
    static int direction[][] = {
            {1, 2, 4, 7},
            {1, 2, 5, 6},
            {1, 3, 6, 7},
            {1, 3, 4, 5}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] info = br.readLine().split(" ");
            int N = Integer.parseInt(info[0]); // 세로 길이
            int M = Integer.parseInt(info[1]); // 가로 길이
            int L = Integer.parseInt(info[4]); // 소요시간
            Node manhole = new Node(Integer.parseInt(info[2]), Integer.parseInt(info[3]), 1, null); // 맨홀 위치

            int[][] map = new int[N][M];
            for (int n = 0; n < N; n++){
                map[n] = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            }

            int[][] counted = new int[N][M];
            Queue<Node> queue = new LinkedList<>();
            queue.add(manhole);
            counted[manhole.i][manhole.j] = 1;
            int result = 1;

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                if (current.dist > L-1) continue;

                for (int d = 0; d < 4; d++) {
                    int ni = current.i + di[d];
                    int nj = current.j + dj[d];

                    if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
                    if (map[ni][nj] == 0) continue;
                    if (current.prev != null && ni == current.prev.i && nj == current.prev.j) continue;

                    if (isPosible(d, map[current.i][current.j], map[ni][nj])) {
                        queue.add(new Node(ni, nj, current.dist+1, current));
                        if (counted[ni][nj] != 1) {
                            counted[ni][nj] = 1;
                            result++;
                        }
                    }
                }
            }

            bw.append("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }

    static boolean isPosible(int d, int currentPipe, int nextPipe) {
        boolean checkCurrent = false, checkNext = false;
        for (int i = 0; i < 4; i++){
            if (direction[d][i] == currentPipe) checkCurrent = true;
            if (direction[neighbor[d]][i] == nextPipe) checkNext = true;
        }
        return checkCurrent && checkNext;
    }
}

class Node {
    int i, j, dist;
    Node prev;

    Node (int i, int j, int dist, Node prev) {
        this.i = i;
        this.j = j;
        this.dist = dist;
        this.prev = prev;
    }
}
