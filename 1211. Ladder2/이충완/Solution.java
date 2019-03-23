import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int checkTc;
	static int checkJ;

	static int result;
	static int minCount;
	static boolean isUpdate;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int tc = 1; tc <= 10; tc++) {
			checkTc = tc;
			minCount = 100 * 100;
			br.readLine(); // tc

			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				int j = 0;
				StringTokenizer parser = new StringTokenizer(br.readLine(), " ");
				while (parser.hasMoreTokens()) {
					map[i][j++] = Integer.parseInt(parser.nextToken());
				}
			}

			for (int j = 0; j < 100; j++) {

				checkJ = j;
				if (map[0][j] == 1) {
					isUpdate = false;
					go(1, j, 1, "남");
					if (isUpdate) {
						result = j;
					}
				}
			}

			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		bw.close();

	}

	public static void go(int x, int y, int count, String direction) {
		if (minCount < count)
			return;

		if (x == 100) {
			if (count <= minCount) {
				minCount = count;
				isUpdate = true;
			}
			return;
		}

		if (y - 1 >= 0 && map[x][y - 1] == 1 && !direction.equals("동")) {
			go(x, y - 1, ++count, "서");
		} else if (y + 1 < 100 && map[x][y + 1] == 1 && !direction.equals("서")) {
			go(x, y + 1, ++count, "동");
		} else {
			go(x + 1, y, ++count, "남");
		}
	}

}
