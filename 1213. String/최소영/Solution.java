package sw1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = 10;
		for(int testcase = 1; testcase<=TC; testcase++) {
			String test = br.readLine();
			String search = br.readLine();
			String sentence = br.readLine();
			String temp = sentence.replaceAll(search, "");
			int diff = sentence.length() - temp.length();
			int answer = diff/search.length();
			
			System.out.println("#"+testcase+" "+answer);
		}
	}
}
