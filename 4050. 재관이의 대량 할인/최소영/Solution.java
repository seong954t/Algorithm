package sw4050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase<=TC; testcase++) {
			int clothNum= Integer.parseInt(br.readLine());
			String first[] = br.readLine().split(" ");
			int pack = clothNum/3;
			int rm = clothNum%3;
			int result = 0;
			Integer temp[] = new Integer[clothNum];
			for(int i = 0; i <clothNum; i++) {
				temp[i] = Integer.parseInt(first[i]);
			}
			int size = 0;
			Arrays.sort(temp, Collections.reverseOrder());
			
			for(int i = 0; i <temp.length;i+=3) {
				if(i == temp.length-1) {
					result += temp[i];
				}else {
					result += temp[i]+temp[i+1];
				}
			}
			
			System.out.println("#"+testcase+" "+result);
			
		}
	}
}