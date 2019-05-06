package sw1222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int testcase = 1; testcase<11; testcase++) {
			int size = Integer.parseInt(br.readLine());
			String cal = br.readLine();
			String[]temp = cal.split("\\+");
			int answer = 0;
			for(int i =0 ; i<temp.length;i++) {
				answer += Integer.parseInt(temp[i]);
			}
			System.out.println("#"+testcase+" "+answer);
		}
	}
}