public class Solution_3143 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String str[] = br.readLine().split(" ");
			String A = str[0];
			String B = str[1];
			
			int alen = A.length(), blen = B.length(), count=0; 
			for(int i=0; i<alen; i++) {
				if(A.charAt(i) == B.charAt(0) && alen-i >= blen) {
					int j;boolean flag = true;
					for(j=1; j<blen; j++) {
 						if(A.charAt(i+j) != B.charAt(j)) {
 							flag = false;
 							j = blen-1;
 						}
					}
					if(flag) {
						count++;
						i += blen-1; 
					}					
				}
			}			
			System.out.println("#"+tc+" "+(alen-(count*blen)+count));	
		}
		br.close();
	}
}
