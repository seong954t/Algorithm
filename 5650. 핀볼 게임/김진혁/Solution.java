package _5650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int[][] wormhole;
	
	static int[] dirY = {1, 0, -1, 0};
	static int[] dirX = {0, 1, 0, -1};
	
	static int[][] map;
	static int N;
	static int[][] obstacle = { {1,3,0,2},{2,3,1,0},{2,0,3,1},{3,2,0,1},{2,3,0,1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		
		
		for(int t= 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			
			map = new int[N][N];
			wormhole = new int[5][2];
			ArrayList<Integer> sp = new ArrayList<Integer>();
			int maxValue = 0;
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for(int j = 0; j < N; j++) {
					int position = Integer.parseInt(st.nextToken());
					map[i][j] = position;
					
					if(position == 0) {
						sp.add(i*100+j);
					}
					if(6 <= position && position <= 10) {
						if(wormhole[position-6][0] == 0) {
							wormhole[position-6][0] = i*100 + j;
						}else {
							wormhole[position-6][1] = i*100 + j;
						}
					}
					
				}
			}
			
			
			for(int i = 0; i < sp.size(); i++) {
				for(int dir = 0; dir < 4; dir++) {
					int yValue = sp.get(i)/100;
					int xValue = sp.get(i)%100;
//					System.out.println("start : " + yValue + " " + xValue);
					maxValue = Math.max(start(yValue, xValue, dir), maxValue);
				}
			}
			
			bw.write("#"+t + " "+ maxValue + "\n");
		}
		bw.flush();
		bw.close();

	}

	private static int start(int y, int x, int dir) {
		int score = 0;
		
		int yDirect = y + dirY[dir];
		int xDirect = x + dirX[dir];
		
		while(true) {
//			System.out.println(yDirect + " " + xDirect);
			if(xDirect < 0) {
				xDirect++;
				dir = 1;
				score++;
			}else if(xDirect >= N) {
				xDirect--;
				dir = 3;
				score++;
			}else if(yDirect < 0) {
				yDirect++;
				dir = 0;
				score++;
			}else if(yDirect >= N) {
				yDirect--;
				dir = 2;
				score++;
			}
						
			if( (xDirect == x && yDirect == y) || (map[yDirect][xDirect] == -1) ) {
				return score;
			}
			
			
			if(1 <= map[yDirect][xDirect] &&  map[yDirect][xDirect] <= 5) {
				dir = obstacle[map[yDirect][xDirect]-1][dir];
				score++;
			}else if(6 <=map[yDirect][xDirect] &&map[yDirect][xDirect] <= 10) {
				int wormholeIndex = map[yDirect][xDirect]-6;
				if(wormhole[wormholeIndex][0] == yDirect*100 + xDirect) {
					yDirect = wormhole[wormholeIndex][1] / 100;
					xDirect = wormhole[wormholeIndex][1] % 100;
				}else {
					yDirect = wormhole[wormholeIndex][0] / 100;
					xDirect = wormhole[wormholeIndex][0] % 100;
				}
			}
			
			yDirect = yDirect + dirY[dir];
			xDirect = xDirect  + dirX[dir];
			
		}
		
	}

}
