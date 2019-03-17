package sw1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int testcase = 1; testcase <=10; testcase++) {
			int dump = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			
			int maxIndex = 0;
			int minIndex = 0;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < dump; i++) {
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;
				for(int j = 0; j < 100; j++) {
					int temp = Integer.parseInt(arr[j]);
					
					if(max<=temp) {
						max = temp;
						maxIndex = j;
					}
					if(min>=temp) {
						min = temp;
						minIndex = j;
					}
					
					
					
				}
				if(cal(arr,maxIndex,minIndex)<=1) {
					break;
				}
				arr[maxIndex] = String.valueOf(Integer.parseInt(arr[maxIndex])-1);
				arr[minIndex] = String.valueOf(Integer.parseInt(arr[minIndex])+1);
			}

			System.out.println("#"+testcase+" "+(max-min));
		}
	}
	public static int cal(String[]arr, int max, int min) {
		return Integer.parseInt(arr[max])-Integer.parseInt(arr[min]);
	}
}
