import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int N;
	static int numberOfChecked;
	static int result;
	static int numberOfMine;
	static int[][] countMap;
	static char[][] map;
	static int[][] points = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };
	static boolean[][] visited;
	static Queue<Point> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			result = N * N;
			numberOfChecked = 0;
			numberOfMine = 0;
			map = new char[N][N];
			countMap = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			setCountMap();
			if (queue.isEmpty())
				bw.write("#" + tc + " " + (result - numberOfMine) + "\n");
			else {
				int click = 0;
				while (!queue.isEmpty()) {
					Point point = queue.poll();
					if (!visited[point.x][point.y]) {
						click++;
						go(point.x, point.y);
					}
				}
				bw.write("#" + tc + " " + (result - numberOfChecked - numberOfMine + click) + "\n");
			}
		}
		bw.flush();
		bw.close();
	}

	private static void go(int x, int y) {
		visited[x][y] = true;
		numberOfChecked++;
		if (countMap[x][y] == 0) {
			for (int[] point : points) {
				if (x + point[0] >= 0 && x + point[0] < N && y + point[1] >= 0 && y + point[1] < N
						&& !visited[x + point[0]][y + point[1]]) {
					go(x + point[0], y + point[1]);
				}
			}
		}
	}

	private static void setCountMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				switch (map[i][j]) {
				case '*':
					countMap[i][j] = -1;
					numberOfMine++;
					break;
				case '.':
					checkMine(i, j);
					break;
				default:
					break;
				}
			}
		}
	}

	private static void checkMine(int x, int y) {
		int mine = 0;
		for (int[] point : points) {
			if (x + point[0] >= 0 && x + point[0] < N && y + point[1] >= 0 && y + point[1] < N) {
				if (map[x + point[0]][y + point[1]] == '*')
					mine++;
			}
		}
		countMap[x][y] = mine;
		if (mine == 0)
			queue.add(new Point(x, y));
	}

}
