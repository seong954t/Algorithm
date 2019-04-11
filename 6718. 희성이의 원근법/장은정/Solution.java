import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++) {
			int dCase=0;
			double distance = Integer.parseInt(br.readLine());
			if (distance < 100) {
                dCase = 0;
            } else if (100 <= distance && distance < 1000) {
                dCase = 1;
            } else if (1000 <= distance && distance < 10000) {
                dCase = 2;
            } else if (10000 <= distance && distance < 100000) {
                dCase = 3;
            } else if (100000 <= distance && distance < 1000000) {
                dCase = 4;
            } else {
                dCase = 5;
            }
			System.out.println("#"+tc+" "+dCase);
		}
	}
}






~
~
