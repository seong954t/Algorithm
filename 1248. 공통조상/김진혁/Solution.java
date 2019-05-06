import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] tree;
	static int count;

	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int T = Integer.parseInt(br.readLine());
	
	for(int t = 1; t <= T; t++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int[] vertex = new int[V+1];
		tree = new int[V+1][2];
		count = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int s = 0; s < E; s++) {
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
		
			if(tree[parent][0] == 0) {
				tree[parent][0] = child;
			}else {
				tree[parent][1] = child;
			}
			
			vertex[child] = parent;
		}
		
		int[] xArray = new int[V];
		xArray[0] = X;
		int[] yArray = new int[V];
		yArray[0] = Y;
		
		int temp = 1;
		while(vertex[X] != 0) {
			xArray[temp] = vertex[X];
			X = vertex[X];
			temp++;
		}
		
		temp = 1;
		while(vertex[Y] != 0) {
			yArray[temp] = vertex[Y];
			Y = vertex[Y];
			temp++;
		}
		
		int answerV = 0;
		
		forout:
		for(int x = 0; xArray[x] != 0; x++) {
			for(int y = 0; yArray[y] != 0; y++) {
				if(xArray[x] == yArray[y]) {
					answerV = yArray[y];
					break forout;
				}
			}
		}
		
		dfs(answerV);
		
		bw.write("#"+t+" " + answerV + " " +count + "\n");
		
		
	}
	bw.flush();
	bw.close();
	
	}

	private static void dfs(int v) {
		if(v != 0) {
		count++;
		}
		if(tree[v][0] == 0 && tree[v][1] == 0) {
			return;
		}else {

			dfs(tree[v][0]);
			dfs(tree[v][1]);
		}
		
	}

}
