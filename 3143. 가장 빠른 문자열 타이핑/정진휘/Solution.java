import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int result;
	static String temp_1;
	static String temp_2;
	static int[] count_char;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testnumber = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i = 0; i < testnumber; i++) {
			int count_number = 0;
			st = new StringTokenizer(br.readLine());
			temp_1 = st.nextToken();
			temp_2 = st.nextToken();
			
			count_char = new int[temp_1.length()];
			
			
			/*for(int j = 0; j<temp_1.length(); j++){
				int temp_index = j;
				if(temp_1.charAt(j) == temp_2.charAt(0)){
					count_number += 1;
					count_char[j] = count_number;
					for(int k = 1; k<temp_2.length(); k++){
						if(temp_1.charAt(temp_index+k) == temp_2.charAt(k)){
							j = j+1;
						}
						count_char[j] = count_number;
					}
				}else if(temp_1.charAt(j) != temp_2.charAt(0) && j == 0){
					count_char[j] = 1;
					count_number += 1;
				}else{
					count_number += 1;
					count_char[j] = count_number;
				}
			}*/
			temp_1 = temp_1.replaceAll(temp_2, " ");
			result = temp_1.length();
			
			StringBuilder s = new StringBuilder();
//			s.append("#").append(i + 1).append(" ").append(count_char[count_char.length-1]);
			s.append("#").append(i + 1).append(" ").append(result);
			System.out.println(s);
		}
	}
}
