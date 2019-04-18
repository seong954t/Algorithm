import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] busStop = new int[5001];
			
			for(int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
		
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				
				while(i != j+1) {
					busStop[i]++;
					i++;
				}
			}
			
			int P = Integer.parseInt(br.readLine());
			
			bw.write("#"+t + " ");
			
			for(int p = 0; p < P; p++) {
				bw.write(busStop[Integer.parseInt(br.readLine())] + " ");
			}
			
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		
	}

}
