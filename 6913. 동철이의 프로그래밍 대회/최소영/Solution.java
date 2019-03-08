package sw6913;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Solution {
	public static void main(String[] args) throws IOException {
		ClassLoader cloader = Solution.class.getClassLoader();
		File file = new File(cloader.getResource("sw6913/input.txt").getFile());
		FileReader filereader = new FileReader(file);
		BufferedReader br = new BufferedReader(filereader);
		int TC = Integer.valueOf(br.readLine());
		for(int testCase = 1; testCase <=TC; testCase++) {
			String nm = br.readLine();
			String NM[] = nm.split(" ");
			int n = Integer.valueOf(NM[0]);
			int m = Integer.valueOf(NM[1]);
			ArrayList<Integer> score = new ArrayList<Integer>();
			int max = Integer.MIN_VALUE;

			int personNum = 0;
			
			for(int i =0; i <n; i++) {
				String line = br.readLine();
				int pScore = 0;
				String[] val = line.split(" ");
				for(int j = 0; j < m; j++) {
					if(val[j].equals("1")) {
						pScore++;
					}
				}
				score.add(pScore);
				
				if(max < pScore) {
					max = pScore;
					personNum = 1;
				}else if(max == pScore){
					personNum++;
				}
			}
			System.out.println("#"+testCase+" "+personNum+" "+max);
		}
		
	}
}
