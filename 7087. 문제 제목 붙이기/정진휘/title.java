package al03;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class title {

	static char[] data;
	final static char start = 'A';
	static int[] al_data;


	public static void main(String[] args) throws IOException {
		java.io.BufferedReader br = new java.io.BufferedReader(new InputStreamReader(System.in));
		int testnumber = Integer.parseInt(br.readLine());

		for (int i = 0; i < testnumber; i++) {
			int count = 0;
			// int index = 0;
			data = new char[Integer.parseInt(br.readLine())];

			// 첫번째 문자열 앞글자만 따와서 배열에 삽입
			// 두번째 배열에 sort알고리즘 적용
			// 세번째 sort된 배열에 이어지는지 count를 통해 확인
			for (int j = 0; j < data.length; j++) {
				char c_at = br.readLine().charAt(0);
				data[j] = c_at;
			}
			Arrays.sort(data);
			
			/*for (int j = 0; j < data.length - 1; j++) {
				if (data[j] == start) { // 정렬된 후 j번째가 'A'이면
					count = 1; // count = 1
					for (int k = j; k < data.length - 1; k++) {
						if ((data[k + 1] - data[k] == 1)) {
							count++;
						}else{
							break;
						}
					}
					// count++; //count증가
				}else{
					break;
				}
			}*/
			al_data = new int[26];
			for(int j = 0; j< data.length; j++){
				al_data[data[j]-start] ++;
				
			}
			for(int j = 0; j<al_data.length; j++){
				if(al_data[j] != 0){
					count++;
				}else{
					break;
				}
			}

			StringBuilder s = new StringBuilder();
			s.append("#").append(i + 1).append(" ").append(count);
			System.out.println(s);
		}

	}
}
