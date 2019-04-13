package 인구이동;

import java.io.*;
import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int arr[][] = new int[N][N];
		int MIN = Integer.parseInt(temp[1]);
		int MAX = Integer.parseInt(temp[2]);
		LinkedList<dot> queue = new LinkedList<>();
		int[] for_x = {-1,0,1,0};
		int[] for_y = {0,1,0,-1};
		int count = 0;
		
		for(int i =0; i<N; i++) {
			String[] temp2 = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(temp2[j]);
				
			}
		}
		boolean flag = true;
		
		while(flag) {
			count++;
			flag = false;
		
			boolean[][] dist_check = new boolean[N][N];
			boolean[][] visited = new boolean[N][N];
			
			for(int z=0; z<N*N; z++) {
				int sum = 0;
				int r = z/N;
				int c = z%N;
				if(visited[r][c]) {
					continue;
				}
				queue.add(new dot(r,c,arr[r][c]));
				
				LinkedList<dot> dist = new LinkedList<>();
				
				while(!queue.isEmpty()) {
					int temp_count=0;
					dot a = queue.poll();
				
					for(int i=0; i<4; i++) {	
						int X = a.x + for_x[i];
						int Y = a.y + for_y[i];
					
					if(!visited[a.x][a.y]){
						if(-1<X && X<N && -1<Y && Y<N ){
							if(!dist_check[X][Y] && !visited[X][Y] && MIN<=Math.abs(arr[X][Y]-a.num) && Math.abs(arr[X][Y]-a.num)<=MAX){
								flag = true;
								dist.add(new dot(X,Y,arr[X][Y]));
								dist_check[X][Y] = true;
								queue.add(new dot(X,Y,arr[X][Y]));
								temp_count++;
								continue;
							}
	//						if(!visited[X][Y])
	//							queue.add(new dot(X,Y,arr[X][Y]));
						}
					  }
					}
					if(temp_count>0 && !dist_check[a.x][a.y]) {
						dist.add(a);
					}
					visited[a.x][a.y] = true;
					
					
				}
				
				if(dist.size()>1) {
					for(int i=0; i<dist.size(); i++) {
						sum += dist.get(i).num;
					}
					
					sum = sum/dist.size();
					
					for(int i=0; i<dist.size(); i++) {
						arr[dist.get(i).x][dist.get(i).y] = sum;
					}
				
				}
				}
		}
		System.out.println(count-1);
	}


}

class dot{
	int x;
	int y;
	int num;
	dot(int x,int y,int n){
		this.x = x;
		this.y = y;
		this.num = n;
	}
}
