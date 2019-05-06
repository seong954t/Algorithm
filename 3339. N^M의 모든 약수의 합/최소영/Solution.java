package sw3339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase<=TC; testcase++) {
			String temp = br.readLine();
			long N = Long.parseLong(temp.split(" ")[0]);
			long M = Long.parseLong(temp.split(" ")[1]);
			long max = 1;
			for(long i = 0; i<M; i++) {						
				max = max*N%1000000007;
			}
			
			long answer = 0;
			long i = 1;
			
			for(; i*i<max; i++) {	
				if(max%i==0) {
					answer += i;
					answer += max/i;
				}
			}
			if(i*i == max) {
				answer += i;
			}
			System.out.println("#"+testcase+" "+answer);
			
		}
	}
}