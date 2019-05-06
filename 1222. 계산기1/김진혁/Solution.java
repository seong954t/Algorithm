import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Solution {

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int t = 1; t <= 10; t++) {
			br.readLine();
			String calculation = br.readLine();
			StringTokenizer num = new StringTokenizer(calculation, "+");
			
			int sum = 0;
			while(num.hasMoreTokens()) {
				sum += Integer.parseInt(num.nextToken());
			}
			
			bw.write("#"+t + " " + sum +"\n");
		}
		
		bw.flush();
		bw.close();

	}

}
