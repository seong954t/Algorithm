import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			br.readLine();

			int maxScore = 0;
			int maxFrequency = 0;
			String[] scores = br.readLine().split(" ");
			int[] frequency = new int[101];

			for (int i = 0; i < 1000; i++) {
				frequency[Integer.parseInt(scores[i])] += 1;
			}

			for (int i = 0; i < frequency.length; i++) {
				if (frequency[i] > maxFrequency) {
					maxFrequency = frequency[i];
					maxScore = i;
				} else if (frequency[i] == maxFrequency) {
					if (i > maxScore) {
						maxFrequency = i;
						maxFrequency = frequency[i];
					}
				}
			}
			bw.write("#" + tc + " " + maxScore + "\n");
		}
		bw.flush();
		bw.close();
	}

}
