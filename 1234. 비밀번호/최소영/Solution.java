package sw1234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static String cal(String temp, int length) {
		int index = -1;
		int count = 0;
		char[] pw = temp.toCharArray();
		length = pw.length;
		for(int i = 0 ; i<length; i++) {
			if(i+1<length) {
				if(pw[i]==pw[i+1] && pw[i] != '-') {
					index = i+1;
					pw[index] = '-';
					pw[index-1] = '-';
					int right = index+1;
					int left = index-2;
					while(true) {
						if(right<length && left >=0) {
							if(pw[right]==pw[left] && pw[right] != '-') {
								pw[right] = '-';
								pw[left] = '-';
								right++;
								left--;
								i = right-1;
							}else {
								break;
							}
						}else {
							break;
						}
					}
				}
			}
		}
		String real = "";
		for(int i = 0 ; i < pw.length; i++) {
			if(pw[i]!='-') {				
				real += String.valueOf(pw[i]);
			}
		}
		return real;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = 10;
		
		for(int testcase = 1; testcase<=TC; testcase++) {
			String temp = br.readLine();
			int length = Integer.parseInt(temp.split(" ")[0]);
			int count = 0;
			String answer = cal(temp.split(" ")[1],length);
			while(true) {
				char pw[] = answer.toCharArray();
				for(int i = 0; i < pw.length; i++) {
					if(pw[i] != '-') {
						count++;
					}
				}
				if(answer.equals(cal(answer, count))) {
					break;
				}else {
					answer = cal(answer, count);
				}
			}
			
			System.out.print("#"+testcase+" ");
			char pw[] = answer.toCharArray();
			for(int i = 0; i < pw.length; i++) {
				if(pw[i] != '-') {
					System.out.print(pw[i]);
				}
			}
			System.out.println();
		}
		
	}	
	
}
