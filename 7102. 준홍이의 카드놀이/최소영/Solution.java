package sw7102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase<=TC; testcase++) {
			String temp = br.readLine();
			int N = Integer.parseInt(temp.split(" ")[0]);
			int M = Integer.parseInt(temp.split(" ")[1]);
			int sol = 0;
			String solution = "";
			if(N>M) {
				for(int i = 1; i <= N-M+1; i++) {
					solution += String.valueOf(M+i)+" ";
				}
			}else {
				solution = String.valueOf(N+1);
			}
			
			System.out.println("#"+testcase+" "+solution);
		}
		
	}
}

