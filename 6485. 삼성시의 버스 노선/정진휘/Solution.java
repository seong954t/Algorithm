import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] A;
	static int[] B;
	static int P;
	static int[] C;

	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testnumber = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < testnumber; i++) {
			N = Integer.parseInt(br.readLine());
			A = new int[N];
			B = new int[N];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				A[j] = Integer.parseInt(st.nextToken());
				B[j] = Integer.parseInt(st.nextToken());
			}

			P = Integer.parseInt(br.readLine());
			C = new int[P];
			result = new int[P];

			for (int j = 0; j < P; j++) {
				C[j] = Integer.parseInt(br.readLine());
			}

			for (int k = 0; k < P; k++) {
				for (int j = 0; j < N; j++) {
					int index_A = A[j];
					int index_B = B[j];
					if (index_A <= C[k] && C[k] <= index_B)
						result[k]++;
				}
			}

			StringBuilder s = new StringBuilder();
			s.append("#").append(i + 1);
			for (int j = 0; j < P; j++) {
				s.append(" ").append(result[j]);
			}
			System.out.println(s);
		}
	}
}
