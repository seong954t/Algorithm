package sw1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcase; tc++) {
			String temp = br.readLine();
			int num = Integer.parseInt(temp.split(" ")[1]);
			char[] number = temp.split(" ")[0].toCharArray();
			int change = 0;
			boolean equal = false;
			int e1 = 0;
			int e2 = 0;
			for (int i = 0; i < number.length; i++) {
				if (change == num)
					break;
				char max = number[i];
				int maxIdx = i;
				for (int j = number.length - 1; j > i; j--) {
					if (max < number[j]) {
						max = number[j];
						maxIdx = j;
					} else if (max == number[j]) {
						equal = true;
						e1 = j;
						e2 = i;
					}
				}

				if (number[i] < number[maxIdx]) {
					char tmp2 = number[maxIdx];
					number[maxIdx] = number[i];
					number[i] = tmp2;
					change++;

				}
			}
			if (change < num) {
				if (equal) {
					equal = false;
				} else {
					while (change < num) {
						char tmp = number[number.length - 1];
						number[number.length - 1] = number[number.length - 2];
						number[number.length - 2] = tmp;
						change++;
					}
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < number.length; i++) {
				System.out.print(number[i]);
			}
			System.out.println();
		}
	}

}
