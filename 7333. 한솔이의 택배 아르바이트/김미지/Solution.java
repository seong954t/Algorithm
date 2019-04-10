import java.io.*;
import java.util.Arrays;

public class Solution {
	static int n;
	static int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_num = Integer.parseInt(br.readLine());
		
		for(int z=1;z<=test_num; z++) {
			n = Integer.parseInt(br.readLine());
			int count = 0;
			int j =0;
			arr = new int[n];
			for(int i=0; i<n; i++) {
				int x = Integer.parseInt(br.readLine());
				if(x>=50) {
					count++;
				}else {
					arr[j++] = x;
				}
			}
			if(j == 0) {
				 sb.append('#').append(z).append(' ')
                 .append(count).append('\n');
				continue;
			}
			Arrays.sort(arr,0,j);
			int temp = arr[--j];
			int sum = temp;
			for(int i=0; i<j; i++) {
				sum+=temp;
				if(sum>=50) {
					temp = arr[--j];
					sum = temp;
					count++;
				}
			}
			 sb.append('#').append(z).append(' ')
             .append(count).append('\n');
		}
		System.out.println(sb);
		br.close();
	}

}