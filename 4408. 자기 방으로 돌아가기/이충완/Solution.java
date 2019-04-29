import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] room = new int[401];
			for (int n = 0; n < N; n++) {
				StringTokenizer parser = new StringTokenizer(br.readLine(), " ");
				int x = 0, y = 0;
				x = Integer.parseInt(parser.nextToken());
				y = Integer.parseInt(parser.nextToken());
				if (x > y) {
					int temp = y;
					y = x;
					x = temp;
				}

				if (x % 2 == 0) {
					x--;
				}
				if (y % 2 == 1) {
					y++;
				}

				for (int i = x; i <= y; i++) {
					room[i]++;
				}

			}

			int result = 1;
			for (int i = 1; i <= 400; i++) {
				if (result < room[i]) {
					result = room[i];
				}
			}
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
