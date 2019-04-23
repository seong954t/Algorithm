import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			int x = N/P;
			int y = N%P;
			
			BigInteger ans = new BigInteger("1");
			
			for(int i = 0; i < P-y; i++) {
				ans = ans.multiply(BigInteger.valueOf(x));
			}
			for(int i = 0; i < y; i++) {
				ans = ans.multiply(BigInteger.valueOf(x+1));
			}
			

			bw.write("#"+t + " " +ans+"\n");
		}
		
		bw.flush();
		bw.close();
		
	}

}
