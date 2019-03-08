import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Poll {
	int male, female;
	boolean check;
	
	public Poll(int male, int female, boolean check) {
		this.male = male;
		this.female = female;
		this.check = check;
	}
}

public class Solution {
	public static void main(String args[]) throws Exception {
		int N, M, testcase, pollCount;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testcase; tc++) {
			ArrayList<Poll> queue = new ArrayList<>();
			pollCount = Integer.parseInt(br.readLine());
			String line[] = br.readLine().split(" ");
			for (int i = 0; i < pollCount; i++) {
				queue.add(new Poll(Integer.parseInt(line[i*2]), Integer.parseInt(line[i*2+1]), false));
			}			
			//	조건 찾기
			for(int i=0; i<pollCount; i++) {
				ArrayList<Poll> checkList = (ArrayList<Poll>) queue.clone();
				ArrayList<Poll> result = new ArrayList<>();
				
				Poll head = checkList.get(i);
				head.check = true;
				result.add(head);
				//	헤드 하나 i로 찍고 암-수 맞는지 비교할 것임 
				boolean flag = false;
				while(true) {
					for(int j=0; j<pollCount; j++) {
						Poll temp = checkList.get(j);
						if(!(temp.check) && head.female == temp.male ) {
							head = temp;
							temp.check = true;
							result.add(temp);
							break;
						}
						if(j == pollCount-1)
							flag = true;
					}					
					if(flag)
						break;
				}
				
				if(result.size() == pollCount) {
					StringBuffer sb = new StringBuffer();
					sb.append("#"+tc);
					for(Poll x : result) {
						sb.append(" "+x.male+" "+x.female);
					}
					System.out.println(sb);
					break;
				}else {
					for(Poll x : checkList) {
						x.check =false;
					}
				}
			}
		}
		
	}

}
