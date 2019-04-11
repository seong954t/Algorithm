import java.io.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_num = Integer.parseInt(br.readLine());
		int test = 1;
		while(test<=test_num) {
			int distance = Integer.parseInt(br.readLine());
			int result = 0;
			
			if(distance<100) {
				result = 0;
			}else if(100<=distance&&distance<1000) {
				result = 1;
			}else if(1000<=distance && distance<10000) {
				result = 2;
			}else if(10000<=distance && distance<100000) {
				result = 3;
			}else if(100000<=distance && distance<1000000) {
				result = 4;
			}else {
				result = 5;
			}
			System.out.println("#"+test+" "+result+"\n");
			//bw.write("#"+test+" "+result+"\n");
			test++;
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
