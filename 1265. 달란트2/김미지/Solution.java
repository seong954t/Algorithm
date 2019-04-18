package 달란트2;

import java.io.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = 1;
		int test_num = Integer.parseInt(br.readLine());
		while(test<=test_num) {
			String[] temp = br.readLine().split(" ");
			int dal = Integer.parseInt(temp[0]);
			int dividing = Integer.parseInt(temp[1]);
			long result = 1;
			int first_resul = dal/dividing;
			int second_resul = dal%dividing;
			
			
			for(int i=0; i<dividing; i++) {
				int mul = first_resul;
				if(i<second_resul) {
					mul = first_resul+1;
				}
				result *= mul;
			}
	
			System.out.println("#"+test+" "+result);
			test++;
		}
	}

}
