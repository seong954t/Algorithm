package sw1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Queue;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = 10;

		Queue<Integer> q = new LinkedList<>();

		for (int testcase = 1; testcase <= TC; testcase++) {
			int temp = 1;
			String test = br.readLine();
			String t = br.readLine();
			for (int i = 0; i < 8; i++) {
				int first = Integer.parseInt(t.split(" ")[i]);
				q.add(first);
			}
			while (temp != 0) {
				for (int i = 1; i < 6; i++) {
					temp = q.poll();
					temp = temp - i;
					if (temp < 0) {
						temp = 0;						
					}
					q.add(temp);
					if (temp == 0) {
						break;						
					}
				}
			}

			System.out.print("#" + testcase + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
}
