package 아기상어;

import java.io.*;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int dx[] = {-1,0,1,0};
		int dy[] = {0,1,0,-1};
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		String[] temp = new String[N];
		LinkedList<dot> queue = new LinkedList<dot>();

		int size = 2;
		
		for(int i=0; i<N; i++) {
			temp = br.readLine().split(" ");
			for(int j =0; j<N; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
				if(arr[i][j] == 9){
					queue.add(new dot(i,j,size));
					arr[i][j] = 0;
				}
			}
		}
		
		int time = 0;
		int eat = 0;
		
		while(true) {
			LinkedList<dot> fish = new LinkedList<>();
			int dist[][] = new int[N][N];
			
			while(!queue.isEmpty()) {
				dot a = queue.poll();
				for(int i=0; i<4; i++){
					int X = a.x+dx[i];
					int Y = a.y+dy[i];
					if(-1<X && X<N && -1<Y && Y<N && dist[X][Y] == 0 && arr[X][Y] <= size)  {//dist 0이면 방문안했던거니까! 
						dist[X][Y] = dist[a.x][a.y]+1;
						if(1<=arr[X][Y] && arr[X][Y]<=6 && arr[X][Y] < size  ) {//물고기 먹이로 쓸 수 있는지 !
							fish.add(new dot(X,Y,dist[X][Y]));
							queue.add(new dot(X,Y,dist[X][Y]));
							continue;
						}
						queue.add(new dot(X,Y,dist[X][Y]));	
					}
				}
			}
			
			if(fish.size() == 0) {
				System.out.println(time);
				return;
			}
			
			dot eatingFish = fish.get(0);
            for(int i=1; i<fish.size(); i++){
                if(eatingFish.dist > fish.get(i).dist) {
                    eatingFish = fish.get(i);
                }
                 
                if(eatingFish.dist == fish.get(i).dist) {
                    if(eatingFish.x > fish.get(i).x){
                        eatingFish = fish.get(i);
                        continue;
                    }else if(eatingFish.x == fish.get(i).x){
                        if(eatingFish.y > fish.get(i).y);
                        eatingFish = fish.get(i);   
                    }
                }   
            }
            time += eatingFish.dist;
            eat++;
            arr[eatingFish.x][eatingFish.y] = 0;
            if(eat == size) {
                size++;
                eat = 0;
            }
            queue.add(new dot(eatingFish.x, eatingFish.y, size));
		}
	}
}
	class dot{
		int x;
		int y;
		int dist;
		public dot(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

