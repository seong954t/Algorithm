import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static int result;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> dot = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			result = 0;
			dot.removeAll(dot);
			String[] info = br.readLine().split(" ");
			N = Integer.parseInt(info[0]);
			M = Integer.parseInt(info[1]);
			int R = Integer.parseInt(info[2]);
			int C = Integer.parseInt(info[3]);
			int L = Integer.parseInt(info[4]);

			map = new int[N][M];
			visited = new boolean[N][M];

			dot.add(new Point(R, C));
			visited[R][C] = true;
			result++;

			for (int i = 0; i < N; i++) {
				int j = 0;
				StringTokenizer parser = new StringTokenizer(br.readLine(), " ");
				while (parser.hasMoreTokens()) {
					map[i][j++] = Integer.parseInt(parser.nextToken());
				}
			}

			for (int i = 1; i < L; i++) {
				int size = dot.size();
				for (int j = 0; j < size; j++) {
					Point point = dot.poll();
					go(point.x, point.y);
				}
			}
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}

	public static void go(int x, int y) {

		switch (map[x][y]) {
		case 1:
			goWest(x, y);
			goEast(x, y);
			goSouth(x, y);
			goNorth(x, y);
			break;
		case 2:
			goSouth(x, y);
			goNorth(x, y);
			break;
		case 3:
			goEast(x, y);
			goWest(x, y);
			break;
		case 4:
			goNorth(x, y);
			goEast(x, y);
			break;
		case 5:
			goEast(x, y);
			goSouth(x, y);
			break;
		case 6:
			goWest(x, y);
			goSouth(x, y);
			break;
		case 7:
			goNorth(x, y);
			goWest(x, y);
			break;
		default:
			break;
		}

	}

	private static void goWest(int x, int y) {
		if (y - 1 >= 0 && !visited[x][y - 1]
				&& (map[x][y - 1] == 1 || map[x][y - 1] == 3 || map[x][y - 1] == 4 || map[x][y - 1] == 5)) {
			visited[x][y - 1] = true;
			dot.add(new Point(x, y - 1));
			result++;
		}
	}

	private static void goEast(int x, int y) {
		if (y + 1 < M && !visited[x][y + 1]
				&& (map[x][y + 1] == 1 || map[x][y + 1] == 3 || map[x][y + 1] == 6 || map[x][y + 1] == 7)) {
			visited[x][y + 1] = true;
			dot.add(new Point(x, y + 1));
			result++;
		}
	}

	private static void goSouth(int x, int y) {
		if (x + 1 < N && !visited[x + 1][y]
				&& (map[x + 1][y] == 1 || map[x + 1][y] == 2 || map[x + 1][y] == 4 || map[x + 1][y] == 7)) {
			visited[x + 1][y] = true;
			dot.add(new Point(x + 1, y));
			result++;
		}
	}

	private static void goNorth(int x, int y) {
		if (x - 1 >= 0 && !visited[x - 1][y]
				&& (map[x - 1][y] == 1 || map[x - 1][y] == 2 || map[x - 1][y] == 5 || map[x - 1][y] == 6)) {
			visited[x - 1][y] = true;
			dot.add(new Point(x - 1, y));
			result++;
		}
	}
}
