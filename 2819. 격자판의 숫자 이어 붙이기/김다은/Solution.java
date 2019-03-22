import java.io.*;
import java.util.*;

public class Solution {
    static int di[] = {-1, 1, 0, 0};
    static int dj[] = {0, 0, -1, 1};
    static int[][] grid;
    static HashSet<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int size = 4;
        for (int t = 1; t <= T; t++) {
            grid = new int[size][size];
            result = new HashSet<>();
            for (int i = 0; i < size; i++) {
                grid[i] = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            }

            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    dfs(i, j, grid[i][j], 1);


            bw.append("#" + t + " " + result.size() + "\n");
            bw.flush();
        }
        bw.close();
    }

    static void dfs(int i, int j, int number, int count) {
        if (count == 7) {
            result.add(number);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni < 0 || ni >= 4 || nj < 0 || nj >= 4) continue;
            dfs(ni, nj, (number)*10 + grid[ni][nj], count+1);
        }
    }
}