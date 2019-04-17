package 김진혁;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {

	static int R, C;
	static char[][] map;
	static String ans;
	static int[][][] memoryMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// < : 60
		// > : 62
		// ^ : 94
		// v : 118
		// _ : 95
		// | : 124
		// ? : 63
		// . : 46
		// @ : 64
		// + : 43
		// - : 45
		// 1 : 49
		// 9 : 57

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];
			memoryMap = new int[R][C][16];
			ans = "NO";

			for (int r = 0; r < R; r++) {
				map[r] = br.readLine().toCharArray();
			}

			Solution(0, 0, 0, 1, 0);

			bw.write("#" + t + " " + ans + "\n");

		}

		bw.flush();
		bw.close();

	}

	private static void Solution(int y, int x, int nextY, int nextX, int memory) {
		
		int value = map[y][x];
		
		if(value == '@') {
			ans = "YES";
			return;
		}else if(memoryMap[y][x][memory] == 2){
			return;
		}
		
		switch(value) {
		case '<':
			nextY = 0;
			nextX = -1;
			
			memoryMap[y][x][memory]++;
			
			Solution(calY(y, nextY),calX(x, nextX), nextY, nextX, memory);
			break;
			
		case '>':
			nextY = 0;
			nextX = 1;
			
			memoryMap[y][x][memory]++;
			
			Solution(calY(y, nextY),calX(x, nextX), nextY, nextX, memory);
			break;
			
		case '^':
			nextY = -1;
			nextX = 0;
			
			memoryMap[y][x][memory]++;
			
			Solution(calY(y, nextY),calX(x, nextX), nextY, nextX, memory);
			break;
			
		case 'v':
			nextY = 1;
			nextX = 0;
			
			memoryMap[y][x][memory]++;
			
			Solution(calY(y, nextY),calX(x, nextX), nextY, nextX, memory);
			break;
			
		case '?':
			
			memoryMap[y][x][memory]++;
			
			Solution(calY(y, 0),calX(x, 1), 0, 1, memory);
			Solution(calY(y, 0),calX(x, -1), 0, -1, memory);
			Solution(calY(y, 1),calX(x, 0), 1, 0, memory);
			Solution(calY(y, -1),calX(x, 0), -1, 0, memory);
			break;
			
		case '_':
			if (memory == 0) {
				nextY = 0;
				nextX = 1;
			} else {
				nextY = 0;
				nextX = -1;
			}
			memoryMap[y][x][memory]++;
			
			Solution(calY(y, nextY),calX(x, nextX), nextY, nextX, memory);
			break;
			
		case '|':
			if (memory == 0) {
				nextY = 1;
				nextX = 0;
			} else {
				nextY = -1;
				nextX = 0;
			}
			memoryMap[y][x][memory]++;
			
			Solution(calY(y, nextY),calX(x, nextX), nextY, nextX, memory);
			break;
			
		case '+':
			if (memory == 15) {
				memory = 0;
			} else {
				memory++;
			}
			
			memoryMap[y][x][memory]++;
			
			Solution(calY(y, nextY),calX(x, nextX), nextY, nextX, memory);
			break;
			
		case '-':
			if (memory == 0) {
				memory = 15;
			} else {
				memory--;
			}
			
			memoryMap[y][x][memory]++;
			
			Solution(calY(y, nextY),calX(x, nextX), nextY, nextX, memory);
			break;
			
		case '.':
			memoryMap[y][x][memory]++;
			
			Solution(calY(y, nextY),calX(x, nextX), nextY, nextX, memory);
			break;
		default:
			memory = (int) value - 48;
		
			memoryMap[y][x][memory]++;
			
			Solution(calY(y, nextY),calX(x, nextX), nextY, nextX, memory);
			break;
		}
	}

	private static int calX(int x, int nextX) {
		x = x + nextX;
		
		if(x == C) {
			x = 0;
		}else if(x < 0) {
			x = C - 1;
		}
		
		return x;
	}
	
	private static int calY(int y, int nextY) {
		y = y + nextY;
		
		if(y == R) {
			y = 0;
		}else if(y < 0) {
			y = R - 1;
		}
		
		return y;
	}
}
