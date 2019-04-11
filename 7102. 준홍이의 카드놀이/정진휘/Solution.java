import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int result;
	static int[] N_data;
	static int[] M_data;
	static int[] result_data;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testnumber = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i = 0; i < testnumber; i++) {
			result = 0;
			int max = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			N_data = new int[N];
			M_data = new int[M];
			
			result_data = new int[N+M];
			
			for(int j = 1; j<=N; j++){
				for(int k = 1; k<=M; k++){
					result_data[j+k-1]++;
				}
			}
			StringBuilder s = new StringBuilder();
			s.append("#").append(i + 1);
			
			for(int j = 0; j<result_data.length-1; j++){
				if(max<result_data[j]){
					max = result_data[j];
				}
			}
			
			for(int j = 0; j<result_data.length-1; j++){
				if(max == result_data[j]){
					s.append(" ").append(j+1);
				}
			}
			
			System.out.println(s);
		}
	}
}
