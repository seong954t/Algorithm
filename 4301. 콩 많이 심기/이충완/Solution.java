import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int result = 0;
			String[] info = br.readLine().split(" ");
			N = Integer.parseInt(info[0]);
			M = Integer.parseInt(info[1]);
			boolean[][] map = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!map[i][j]) {
						result++;
						map[i][j] = true;
						map = hateCheck(i, j, map);
					}
				}
			}
			bw.write("#" + tc + " " + result + "\n");

		}

		bw.flush();
		bw.close();
	}

	private static boolean[][] hateCheck(int x, int y, boolean[][] map) {
		if (x + 2 < N) {
			map[x + 2][y] = true;
		}
		if (x - 2 >= 0) {
			map[x - 2][y] = true;
		}
		if (y + 2 < M) {
			map[x][y + 2] = true;
		}
		if (y - 2 >= 0) {
			map[x][y - 2] = true;
		}
		return map;
	}

}
