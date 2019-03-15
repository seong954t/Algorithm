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

		int maxRow = 0;
		int maxCol = 0;
		int diagonalFromLeftToRight = 0;
		int diagonalFromRightToLeft = 0;
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();

			int[][] arr = new int[100][100];

			for (int i = 0; i < 100; i++) {
				int j = 0;
				int lineRow = 0;

				StringTokenizer parser = new StringTokenizer(br.readLine(), " ");
				while (parser.hasMoreElements()) {
					arr[i][j] = Integer.parseInt(parser.nextToken());
					lineRow += arr[i][j];
					j++;
				}

				maxRow = lineRow > maxRow ? lineRow : maxRow;
			}

			// ÁÂ -> ¿ì ´ë°¢¼±
			for (int i = 0; i < 100; i++) {
				diagonalFromLeftToRight += arr[i][i];
			}

			// ¿ì -> ÁÂ ´ë°¢¼±
			for (int i = 0, j = 99; i < 100; i++, j--) {
				diagonalFromRightToLeft += arr[i][j];
			}

			for (int j = 0; j < 100; j++) {
				int lineCol = 0;
				for (int i = 0; i < 100; i++) {
					lineCol += arr[i][j];
				}
				maxCol = lineCol > maxCol ? lineCol : maxCol;
			}

			bw.write("#" + tc + " "
					+ Math.max(Math.max(maxRow, maxCol), Math.max(diagonalFromLeftToRight, diagonalFromRightToLeft))
					+ "\n");
		}
		bw.flush();
		bw.close();
	}

}
