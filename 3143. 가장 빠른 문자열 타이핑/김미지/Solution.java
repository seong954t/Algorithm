import java.io.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_num = Integer.parseInt(br.readLine());
		int test = 1;
		
		while(test<=test_num) {
			String temp[] = br.readLine().split(" ");
			int word_num = temp[0].length();
			String temp2[] = temp[0].split(temp[1]);
			int count = 0;
			
			for(int i=0; i<temp2.length; i++){
				if(!(temp2[i].equals(""))){
					count += temp2[i].length();
				}
			}
			
			word_num = (word_num-count)/temp[1].length();
			count+=word_num;
			System.out.println("#"+test+" "+count);
			test++;
			//bw.write("#"+test+" "+count+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}