import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	
	static BigInteger result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testnumber = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < testnumber; i++) {
			 result = new BigInteger("1");
			 st = new StringTokenizer(br.readLine());
			 N = Integer.parseInt(st.nextToken());
			 M = Integer.parseInt(st.nextToken());
			 
			 int divide = N/M;
			 int mod = N%M;
			 
			 for(int j = 0; j<mod; j++){
				 result = result.multiply(BigInteger.valueOf(divide).add(BigInteger.ONE));
			 }
			 for(int j = 0; j<M-mod; j++){
				 result = result.multiply(BigInteger.valueOf(divide));
			 }

			StringBuilder s = new StringBuilder();
			s.append("#").append(i + 1).append(" ").append(result);
			System.out.println(s);
		}
	}
}
