import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			int j = 0;
			int[] prices = new int[N];
			StringTokenizer parser = new StringTokenizer(br.readLine(), " ");
			while (parser.hasMoreTokens()) {
				prices[j] = Integer.parseInt(parser.nextToken());
				result += prices[j];
				j++;
			}

			Arrays.sort(prices);
			int discount = N / 3;
			for (int k = N - 3; 0 < discount; k -= 3) {
				result -= prices[k];
				discount--;
			}
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}

}
