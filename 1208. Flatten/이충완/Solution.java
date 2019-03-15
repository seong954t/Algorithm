import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	private static int getMaxIdx(int[] arr) {
		int maxIdx = 0;
		int maxValue = 0;
		for (int i = 0; i < 100; i++) {
			if (maxValue < arr[i]) {
				maxIdx = i;
				maxValue = arr[i];
			}
		}
		return maxIdx;
	}

	private static int getMinIdx(int[] arr) {
		int minIdx = 0;
		int minValue = 100;
		for (int i = 0; i < 100; i++) {
			if (arr[i] < minValue) {
				minIdx = i;
				minValue = arr[i];
			}
		}
		return minIdx;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int tc = 1; tc <= 10; tc++) {

			int dump = Integer.parseInt(br.readLine());
			int[] boxArr = new int[100];
			StringTokenizer parser = new StringTokenizer(br.readLine(), " ");
			int index = 0;
			while (parser.hasMoreElements()) {
				boxArr[index++] = Integer.parseInt(parser.nextToken());
			}

			for (int i = 0; i < dump; i++) {
				boxArr[getMaxIdx(boxArr)]--;
				boxArr[getMinIdx(boxArr)]++;
			}
			bw.write("#" + tc + " " + (boxArr[getMaxIdx(boxArr)] - boxArr[getMinIdx(boxArr)]) + "\n");
		}
		bw.flush();
		bw.close();
	}

}
