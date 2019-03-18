package sw7087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=testcase; tc++){
			boolean ascii[] = new boolean[91];
			int num = Integer.parseInt(br.readLine());
			for(int i = 0 ; i < num; i++) {
				char title[] = br.readLine().toCharArray();
				ascii[title[0]] = true;
				
			}
			
			int count = 0;
			for(int i = 65; i < ascii.length; i++) {
				if(ascii[i]) {
					count++;
					continue;
				}else {
					break;
				}
			}
			System.out.println("#"+tc+" "+count);
			
		}
	}
}
