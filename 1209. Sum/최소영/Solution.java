package sw1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testcase = 1; testcase <=10; testcase++) {
			testcase = Integer.parseInt(br.readLine());
			int arr[][] = new int[100][100];
			for(int i = 0; i <100; i++) {
				String strH[] = br.readLine().split(" ");
				for (int j = 0; j< strH.length; j++) {
					arr[i][j]= Integer.parseInt(strH[j]);
				}
			}	
			int maxRow = -1;
			int maxCol = -1;
			int dig1 = 0;
			int dig2 = 0;
			for(int i = 0; i < 100; i++) {
				int col = 0;
				int row = 0;
				
				for(int j = 0 ; j < 100; j++) {
					col += arr[i][j];
					row += arr[j][i];
				}
				dig1 += arr[i][i];
				dig2 += arr[arr.length-1][i];
				
				maxRow = Math.max(maxRow, row);
				maxCol = Math.max(maxCol, col);
			}
			
			System.out.println("#"+testcase+" "+Math.max(Math.max(maxRow, maxCol),Math.min(dig1, dig2)));
		}
	}
}
