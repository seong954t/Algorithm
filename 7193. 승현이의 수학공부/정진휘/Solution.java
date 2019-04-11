import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int result;
	static String X;
	static long data;
	static long X_10 = 0;
	static int N;
	static char[] X_data;
	static int count = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testnumber = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i = 0; i < testnumber; i++) {
			result = 0;
			st = new StringTokenizer(br.readLine());
			
			X_10 = 0;
			
			N = Integer.parseInt(st.nextToken());
			X = st.nextToken();
			
			int index = 0;
			while(index<X.length()){
				result = result + (X.charAt(index)-'0'); 
				index++;
			}
			
			result = result % (N-1);
			
			StringBuilder s = new StringBuilder();
			s.append("#").append(i + 1).append(" ").append(result);
			System.out.println(s);
		}
	}
	
}
