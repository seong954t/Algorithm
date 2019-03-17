package sw1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = 1;
		for(;testcase<=10;testcase++) {
			int width = Integer.parseInt(br.readLine());
			int[] building = new int[width];
			String strH[] = br.readLine().split(" ");
			
			for (int i = 0; i < strH.length; i++) {
				building[i]= Integer.parseInt(strH[i]);
			}
			int View = 0;
			for(int i = 2; i < width -2; i++) {
				int currentB = building[i];
				int left = building[i-1];
				int left2 = building[i-2];
				int right = building[i+1];
				int right2 = building[i+2];
				
				int max = Math.max(Math.max(left, left2),Math.max(right, right2));
				
				if(max < currentB) {
					View += currentB-max;
				}
			}
			System.out.println("#"+testcase+" "+View);
		}
	}
}
