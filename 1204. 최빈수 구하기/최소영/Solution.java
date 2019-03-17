package sw1204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= tc; test_case++) {
			int NumOfTC = Integer.parseInt(br.readLine());
			int[] score = new int[101];
			String input = null;
			
			String score_str[] = br.readLine().split(" ");
			for (int i = 1; i < score_str.length; i++) {
				int idx = Integer.parseInt(score_str[i]);
				score[idx]++;
			}
			
			int max = -1;
			int index = 0;
			for(int i = 100; i>0; i--) {
				if(max<score[i]) {
					max = score[i];
					index = i;
				}
			}
			System.out.println("#" + NumOfTC + " " + index + "\n");
		}
	}
}
