import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; testcase++) {
			String temp = br.readLine();
			long dalant = Integer.parseInt(temp.split(" ")[0]);
			long num = Integer.parseInt(temp.split(" ")[1]);
			
			long total = 1;
			
			long max = dalant/num;
			long remainder = dalant%num;
			
			for(int i = 0; i < num-remainder; i++) {
				total *= max;
			}
			max++;
			for(int i = 0; i < remainder; i++) {
				total *= max;
			}
			
			System.out.println("#"+testcase+" "+total);
		}

	}
}
