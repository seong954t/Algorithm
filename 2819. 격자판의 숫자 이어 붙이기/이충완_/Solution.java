import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			set.removeAll(set);
			String[][] map = new String[4][4];

			for (int i = 0; i < 4; i++) {
				StringTokenizer parser = new StringTokenizer(br.readLine(), " ");
				int j = 0;
				while (parser.hasMoreTokens()) {
					map[i][j++] = parser.nextToken();
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					go(i, j, map[i][j], map);
				}
			}
			bw.write("#" + tc + " " + set.size() + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void go(int x, int y, String numbers, String[][] map) {
		if (numbers.length() == 7) {
			set.add(numbers);
			return;
		}

		if (x - 1 >= 0)
			go(x - 1, y, numbers + map[x - 1][y], map);
		if (x + 1 < 4)
			go(x + 1, y, numbers + map[x + 1][y], map);
		if (y - 1 >= 0)
			go(x, y - 1, numbers + map[x][y - 1], map);
		if (y + 1 < 4)
			go(x, y + 1, numbers + map[x][y + 1], map);
	}

}
