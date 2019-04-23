package 백만장자프로젝트;

import java.io.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_num = Integer.parseInt(br.readLine());
		int test =1;
		while(test<=test_num) {
			br.readLine();
			String[] temp = br.readLine().split(" ");
			long result = 0;
			int MAX = Integer.parseInt(temp[temp.length-1]);
			for(int i =temp.length-2; i>=0; i--) {
				if(MAX>Integer.parseInt(temp[i])) {
					result += (long)(MAX-Integer.parseInt(temp[i]));
				}else{
					MAX = Integer.parseInt(temp[i]);
				}
			}
			System.out.println("#"+test+" "+result);
			test++;
		}
		
	}
}