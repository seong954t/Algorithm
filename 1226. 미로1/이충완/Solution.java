package com.미로1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static boolean isFind;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            int startX = 0;
            int startY = 0;
            isFind = false;
            map = new int[16][16];
            visited = new boolean[16][16];

            for (int i = 0; i < 16; i++) {
                String[] info = br.readLine().split("");
                for (int j = 0; j < 16; j++) {
                    map[i][j] = Integer.parseInt(info[j]);
                    if (map[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            dfs(startX, startY);

            if (isFind)
                result.append("#").append(tc).append(" 1\n");
            else
                result.append("#").append(tc).append(" 0\n");


        }
        System.out.println(result.toString());
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (map[nextX][nextY] == 3) {
                isFind = true;
                return;
            } else if (map[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                dfs(nextX, nextY);
            }
        }
    }

}
