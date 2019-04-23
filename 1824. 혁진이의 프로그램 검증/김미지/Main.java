package 연구소3;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main{
	static int R,C=0;
	static int[] for_X = {-1,0,1,0};
	static int[] for_Y = {0,1,0,-1};
	static int result;
	static int test = 1;
	static boolean resulting;
	static boolean visit;
	static boolean map[][][][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_num = Integer.parseInt(br.readLine());
		
		boolean first_check = false;
		
		while(test<=test_num) {
			String temp[] = br.readLine().split(" ");
			R = Integer.parseInt(temp[0]);
			C = Integer.parseInt(temp[1]);
			String[][] arr =  new String[R][C];
			resulting = false;
			visit = false;
			for(int i=0; i<R; i++) {
				String[] temp_ = br.readLine().split("");
				for(int j = 0; j<C; j++) {
					arr[i][j] = temp_[j];
					if(arr[i][j].equals("@")) {
						first_check = true;
					}
				}
			}
			
			map = new boolean[21][21][16][5];
			result = 0;
			if(first_check)
				search(arr,0,0,1);
			String a = "";
			if(visit) {
				a = "YES";
			}else {
				a = "NO";
			}
			bw.write("#"+test+" "+a+"\n");
			test++;
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void search(String arr[][],int x,int y,int direction) {

		if(resulting) {
			return;
		}
			
		String a = arr[x][y];
			
			switch(a) {
				case "<":
					direction = 3;
					break;
				case ">":
					direction = 1;
					break;

				case "^":
					direction = 0;
					break;
				case "v":
					direction = 2;
					break;
				case "_":
					if(result == 0) {
						direction = 1;
					}else {
						direction = 3; 
					}
					break;
				case "|":
					if(result == 0) {
						direction = 2;
					}else {
						direction = 0;
					}
					break;
				case "?":
					direction = 4;
					break;
				case ".":
					break;
				case "@":
					visit = true;
					resulting = true;
					return;
				case "+":
					if(result == 15) {
						result = 0;
					}else {
						result++;
					}
					break;
				case "-":
					if(result == 0) {
						result = 15;
					}else {
						result --;
					}	
					break;
				default:
					int temp = Integer.parseInt(a);
					result = temp;
					break;
			}
			
			if(map[x][y][result][direction]) {
				resulting = true;
				return;
			}else {
				map[x][y][result][direction] = true;
			}

			List<dot> queue = fill_list(x,y,direction);
			
			for(dot d : queue) {

				if(!visit) resulting = false;
				search(arr,d.x,d.y,d.direction);
			}
			
				
		return;
	}
	private static List<dot> fill_list(int x, int y, int direction){
		List<dot> list = new ArrayList<>();
		
		switch(direction) {
			case 4:
			case 0:
				dot a = new dot(x,y,0);
				if(x-1 < 0) {
					a.x = R-1;
				}else {
					a.x = x-1;
				}
				a.direction = 0;
				list.add(a);
				if(direction!=4) break;
			case 1:
				dot a1 = new dot(x,y,0);
				if(y+1>=C) {
					a1.y = 0;
				}else {
					a1.y = y+1;
				}
				a1.direction = 1;
				list.add(a1);
				if(direction!=4) break;
			case 2:
				dot a2 = new dot(x,y,0);
				if(x+1>=R) {
					a2.x = 0;
				}else {
					a2.x = x+1;
				}
				a2.direction = 2;
				list.add(a2);
				if(direction!=4) break;
			case 3:
				dot a3 = new dot(x,y,0);
				if(y-1<0) {
					a3.y = C-1;;
				}else {
					a3.y = y-1;
				}
				a3.direction = 3;
				list.add(a3);
				if(direction!=4) break;
		}
		return list;
			
	}

}
class dot{
	int x;
	int y;
	int direction;
	
	dot(int x,int y,int direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
}
 