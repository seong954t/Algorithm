import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean[] alphabet = new boolean[27];
			for (int i = 0; i < N; i++) {
				String title = br.readLine();
				char firstCaret = title.charAt(0);
				alphabet[firstCaret - 65] = true;
			}

			int index = 0;
			while (alphabet[index]){
				index++;
			}
			bw.write("#" + tc + " " + index + "\n");
		}
		bw.flush();
		bw.close();
	}

}
