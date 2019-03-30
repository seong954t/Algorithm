package 재관이의대량할인;

import java.io.*;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_num = Integer.parseInt(br.readLine());
		int test =1;
		while(test<=test_num) {
			int clothes_num = Integer.parseInt(br.readLine());
			String[] temp = br.readLine().split(" ");
			int[] result = new int[clothes_num];
			int price = 0;
			for(int i=0; i<clothes_num; i++) {
				result[i] = Integer.parseInt(temp[i]);
			}
			Arrays.sort(result);
			for(int i = clothes_num-1; i>=0; i-=3) {
				if(i==0) {
					price += (result[i]);
				}else {
					price += (result[i]+result[i-1]);
			}
			}
			System.out.println("#"+test+" "+price);
			test++;
		}
	}
}
