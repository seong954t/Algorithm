package 콩많이심기;

import java.io.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_num = Integer.parseInt(br.readLine());
		int test = 1;
		while(test<=test_num) {
			String temp[] = br.readLine().split(" ");
			int M = Integer.parseInt(temp[1]);
			int N = Integer.parseInt(temp[0]);
			boolean[][] arr = new boolean[M][N];
			int result = arr.length*arr[0].length;
		    for(int i=0; i<M; i++) {
		    	for(int j =0; j<N; j++) {
		    		if(!arr[i][j]) {
			    		if(calculate(i,j,M,N,arr)) {
			    			result--;
			    		}
		    		}
		    	}
		    }
		    System.out.println("#"+test+" "+result);
		}
		br.close();
	}
	
	public static boolean calculate(int i, int j, int M, int N, boolean arr[][]) {
			if(i+2<M && (arr[i+2][j]==false)) {
				arr[i+2][j] = true;
				return true;
			}
			if(j+2<N && (arr[i][j+2]==false)){
				arr[i][j+2] = true;
				return true;
			}
		return false;
	}
}