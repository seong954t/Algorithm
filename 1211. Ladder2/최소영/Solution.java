package sw1211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int testcase = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= 10; testcase++) {
			testcase = Integer.parseInt(br.readLine());
			// String temp = br.readLine();
			char[][] ladder = new char[100][100];
			for (int i = 0; i < 100; i++) {
				String tmp[] = br.readLine().split(" ");
				String temp = "";
				for (int j = 0; j < tmp.length; j++) {
					temp += tmp[j];
				}
				ladder[i] = temp.toCharArray();
			}
			int min = Integer.MAX_VALUE;
			int number = 0;
			for (int i = 0; i < 100; i++) {

				if (ladder[0][i] == '0') {
					continue;
				} else {

					int dotX = i;
					int dotY = 1;
					int count = 0;
					char way = 'd';
					while (dotY < 99) {
						if (dotX < 99 && way != 'l' && ladder[dotY][dotX + 1] == '1') {// right
							dotX = dotX + 1;
							way = 'r';
						} else if (dotX > 0 && way != 'r' && ladder[dotY][dotX - 1] == '1') {// left
							dotX = dotX - 1;
							way = 'l';
						} else if(ladder[dotY+1][dotX] == '1'){// down
							dotY = dotY + 1;
							way = 'd';
						}
						count++;
					}

					if (min > count) {
						min = count;
						number = i;
					}
				}

			}
			System.out.println("#" + testcase + " " + number);
		}
	}
}
