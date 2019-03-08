package sw1259;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ClassLoader cloader = Solution.class.getClassLoader();
		File file = new File(cloader.getResource("sw1259/input.txt").getFile());
		FileReader filereader = new FileReader(file);
		BufferedReader br = new BufferedReader(filereader);// 이 경로에 있는 txt파일
		int TC = Integer.valueOf(br.readLine());
		for(int i = 1; i <= TC; i++) {
			int num = Integer.valueOf(br.readLine());
			ArrayList<String> male = new ArrayList<String>();
			ArrayList<String> female = new ArrayList<String>();
			String temp = br.readLine();
			String all[] = temp.split(" ");
			for(int j = 0; j < all.length; j+=2){
				male.add(all[j]);
				female.add(all[j+1]);
			}
		//	new InputStreamReader(System.in);
			ArrayList<String> answer = new ArrayList<String>();
			int count = 0;
			String keep = "";
			int real_length = male.size();
			for(int j = 0; j < real_length; j++) {
				if(female.contains(male.get(0))) {
					
					int feIndex = female.indexOf(male.get(0));
					answer.add(female.get(feIndex));
					answer.add(male.get(0));
					female.remove(feIndex);
					male.remove(0);
				}else {
					if(count == 0) {
						keep = male.remove(0);
						
						count++;
					}else if(count == 1) {
						
					}else if(count >1) {
						break;
					}
				}
			}
			if(female.size()>0) {
				answer.add(0, keep);
				answer.add(female.get(0));
			}
			System.out.print("#"+i+" ");
			for(int j = 0; j < answer.size();j++) {
				System.out.print(answer.get(j)+" ");
			}
			System.out.println();
			
		}
	}
	
}
