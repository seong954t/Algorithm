import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int result;
	static int[][] data;
	static int[][] visit;
	static int N;
	static int K;
	static int[]vector_x = {1,0,-1,0};	//상 하 좌 우
	static int[]vector_y = {0,-1,0,1};
	static int max;
	static ArrayList<Data> list;
	static Data d;
	static int deep;	//그래프 깊이
	static boolean cut;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testnumber = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < testnumber; i++) {
			list = new ArrayList<Data>();
			max = 0;
			result = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			data = new int[N+2][N+2];
			visit = new int[N+2][N+2];
			deep = 0;
			cut = false;
			
			for (int j = 1; j <= N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= N; k++) {
					data[j][k] = Integer.parseInt(st.nextToken());
					if(data[j][k] >= max){
						max = data[j][k];
					}
				}
			}
			for (int j = 1; j<=N; j++){
				for(int k = 1; k<=N; k++){
					if(data[j][k] == max){
						d = new Data();
						d.setX(j);
						d.setY(k);
						list.add(d);
					}
				}
			}
			int count = list.size();
			while(count != 0){
				dfs(list.get(0).getX(), list.get(0).getY());
				list.remove(0);
				count--;
				deep = 0;
			}

			StringBuilder s = new StringBuilder();
			s.append("#").append(i + 1).append(" ").append(result);
			System.out.println(s);
		}
	}
	
	public static void dfs(int x, int y){
		visit[x][y] = 1;
		deep++;
		for(int i = 0; i<4; i++){
			int x_n = x + vector_x[i];
			int y_n = y + vector_y[i];
			
			if(x_n > N || x_n < 1 || y_n > N || y_n <1)	//벗어나는 경우
				continue;
			
			if(visit[x_n][y_n] == 0){
				if(!cut){	//깎은 곳 없음
					if(data[x_n][y_n] < data[x][y]){
						dfs(x_n,y_n);
					}else{
						for(int j = 1; j<=K; j++){
							if(data[x][y] > data[x_n][y_n] - j){	//조금식 깎음
								data[x_n][y_n] = data[x_n][y_n]- j;
								cut = true;	//깎음
								dfs(x_n, y_n);
								data[x_n][y_n] = data[x_n][y_n]+ j;	//원 위치
								cut = false;
							}
						}
					}
				}else{		//깎음
					if(data[x][y] > data[x_n][y_n]){	//더이상 못 깎음
						dfs(x_n,y_n);
					}
				}
			}
		}
		if(result<deep){
			result = deep;	//최대값 저장
		}
		deep--;
		visit[x][y] = 0;
	}
	

 static class Data {
	public int x;
	public int y;
	public Data(){
		
	}
	public void setX(int x){
		this.x = x;
	}
	public int getX(){
		return x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getY(){
		return y;
	}
	
}

}
