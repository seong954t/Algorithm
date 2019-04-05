package sw3143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase<=TC; testcase++) {
			String temp = br.readLine();
			String A = temp.split(" ")[0];
			String B = temp.split(" ")[1];
			String result = A.replaceAll(B, "A");
			
			System.out.println("#"+testcase+" "+result.length());
		}
	}
}
