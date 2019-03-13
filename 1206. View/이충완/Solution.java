package view;

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

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int idx = 0;
			int[] buildings = new int[N];
			StringTokenizer parser = new StringTokenizer(br.readLine(), " ");
			while (parser.hasMoreElements()) {
				buildings[idx++] = Integer.parseInt(parser.nextToken());
			}
			System.out.println("completed input data");
		}
	}

}
