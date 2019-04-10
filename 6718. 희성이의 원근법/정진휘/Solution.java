import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static double change_distance;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testnumber = Integer.parseInt(br.readLine());

		for (int i = 0; i < testnumber; i++) {
			result = 0;
			int distance = Integer.parseInt(br.readLine());
			change_distance = (double)distance / 1000;

			count(change_distance);
			
			StringBuilder s = new StringBuilder();
			s.append("#").append(i + 1).append(" ").append(result);
			System.out.println(s);
		}
	}

	public static void count(double data) {

		while (true) {
			if (data < 0.1) {
				result = result + 0;
				break;
			}else if(data >= 0.1 && data < 1){
				result = result + 1;
				break;
			}else if(data >= 1 && data < 10){
				result = result + 2;
				break;
			}else if(data >= 10 && data < 100){
				result = result + 3;
				break;
			}else if(data >= 100 && data < 1000){
				result = result + 4;
				break;
			}else if(data >= 1000){
				result = result + 5;
				break;
			}
		}
	}

}
