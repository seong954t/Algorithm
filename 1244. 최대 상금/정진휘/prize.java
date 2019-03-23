package al03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prize {

	static String[] data;
	static int[] final_data;
	static String[] temp;
	static int num;
	static int count;
	static int[][] visit;
	static int result;
	
	static int prenum, aftnum;

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testnumber = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < testnumber; i++) {
			result = 0;
			temp = new String[2];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				temp[j] = (st.nextToken());
			}

			data = temp[0].split("");

			count = Integer.parseInt(temp[1]);

			final_data = new int[data.length];
			for (int j = 0; j < data.length; j++) {
				// System.out.println(data[j]);
				final_data[j] = Integer.parseInt(data[j]);
			}

			visit = new int[999999][count+1];
			
			solution(final_data, count);
			
			System.out.println();
			StringBuilder s = new StringBuilder();
			s.append("#").append(i + 1).append(" ").append(result);
			System.out.print(s);

		}
	}
	
	public static void solution(int[] a, int count){
		if(visit[calnum(a)][count] == 1)	//1이면 방문 0이면 비방문
			return ;
		
		visit[calnum(a)][count] = 1;
		
		if(count == 0){
			if(calnum(a) > result){
				result = calnum(a);
			}
			return ;
		}
		
		for (int j = 0; j < a.length - 1; j++) {
			for (int k = j + 1; k < a.length; k++) {
				
					solution(swap(a, j, k), count-1);
			}
		}
	}

	public static int calnum(int[] a) {
		num = 0;

		for (int j = 0; j < a.length; j++) {
			num = (int) (num + (a[a.length - 1 - j] * Math.pow(10, j)));
		}
		return num;
	}
	public static int[] swap(int[] a, int in1, int in2) {
		int[] a_temp = new int[a.length];
		for(int i = 0; i<a.length; i++){
			a_temp[i] = a[i];
		}
		int temp_data = a_temp[in1];
		a_temp[in1] = a_temp[in2];
		a_temp[in2] = temp_data;
		return a_temp;
	}
}
