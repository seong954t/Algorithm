import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int punctuation = Integer.parseInt(st.nextToken());	//	진법
			String beforeTrans = st.nextToken();
			int number =0;
//			long number = Integer.parseInt(st.nextToken());	//	수 
			int mul = 1, temp=0, realPunc = punctuation-1;
			for(int i=beforeTrans.length()-1; i>=0; i--) {
				number += ((beforeTrans.charAt(i) - '0')) % realPunc;
				temp++; 
			}			
			System.out.println("#"+tc+" "+number%realPunc);
		}
	}
}

