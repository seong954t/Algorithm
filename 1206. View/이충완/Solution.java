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

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int idx = 0;
			int[] buildings = new int[N];
			StringTokenizer parser = new StringTokenizer(br.readLine(), " ");
			while (parser.hasMoreElements()) {
				buildings[idx++] = Integer.parseInt(parser.nextToken());
			}

			int result = 0;
			for (int i = 2; i < buildings.length - 2; i++) {
				int viewFloor = 256;
				boolean isOk = true;
				for (int left = i - 1; left > i - 3; left--) {
					if (buildings[left] >= buildings[i]) {
						isOk = false;
						break;
					} else {
						int gap = buildings[i] - buildings[left];
						if (gap < viewFloor)
							viewFloor = gap;
					}
				}
				if (isOk) {
					for (int right = i + 1; right < i + 3; right++) {
						if (buildings[right] >= buildings[i]) {
							isOk = false;
							break;
						} else {
							int gap = buildings[i] - buildings[right];
							if (gap < viewFloor)
								viewFloor = gap;
						}
					}
				}

				if (isOk && viewFloor != 256) {
					result += viewFloor;
				}
			}
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}

}
