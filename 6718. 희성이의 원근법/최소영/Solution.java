package sw7193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=testcase; tc++){
			//100m юлго 0
			int dest = Integer.parseInt(br.readLine());
			int point = 0;
			if(dest<100) {
				point = 0;
			}else if(dest>=100&&dest<1000) {
				point = 1;
			}else if(dest>=1000&&dest<10000) {
				point = 2;
			}else if(dest>=10000&&dest<100000) {
				point = 3;
			}else if(dest>=100000&&dest<1000000){
				point = 4;
			}else {
				point = 5;
			}
			System.out.println("#"+tc+" "+point);
		}
	}
}