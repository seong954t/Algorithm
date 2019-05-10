package _1974;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			
			int[][] map = new int[9][9];
			int answer = 1;
			int test = 0;
			int[] check = new int[10];
			
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					int value = Integer.parseInt(st.nextToken());
					map[i][j] = value;

					if (check[value] == 0) {
						check[value]++;
					} else {
						answer = 0;
						test = 1;
					}
				}
				check = new int[10];
			}

			if (answer != 0) {
				for (int i = 0; i < 9 && answer == 1; i++) {
					for (int j = 0; j < 9 && answer == 1; j++) {
						if (check[map[j][i]] == 0) {
							check[map[j][i]]++;
						}else {
							answer = 0;
							test = 2;
						}
					}
					check = new int[10];
				}
			}
			
			if(answer != 0) {
				int i = 0;
				int j = 0;
				
				for(i = 0; i < 9 && answer == 1; i = i + 3) {
					for(j = 0; j < 9 && answer == 1; j = j + 3) {
						answer = squareCheck(i,j, map);
					}
				}
			}
			
			bw.write("#" + t + " " + answer + "\n");

		}

		bw.flush();
		bw.close();

	}

	private static int squareCheck(int i, int j, int[][] map) {
		int[] check = new int[10];
		
		int iRange = i + 3;
		int jRange = j + 3;
		
		int answer = 1;
		
		int y = i;
		int x = j;
		
		for(i = y; i < iRange && answer == 1; i++) {
			for(j = x; j <jRange && answer == 1 ;j ++) {
				if(check[map[i][j]] == 0) {
					check[map[i][j]]++;
				}else {
					answer = 0;
				}
			}
		}
		return answer;
	}

}
