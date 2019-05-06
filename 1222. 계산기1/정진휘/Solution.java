import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static char data_temp[];
	static char data[];
	static char c_at;
	static int result;
	static Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			int size = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			data_temp = new char[size];
			data = new char[size];
			result = 0;
			
			for(int j = 0; j<size; j++){
				c_at = str.charAt(j);
				data_temp[j] = c_at;
			}
			
			System.arraycopy(data_temp, 2, data, 1, size-2);
			
			data[0] = data_temp[0];
			data[size-1] = '+';
			
			for(int j = 0; j<size; j++){
				if(data[j] >= '0' && data[j]<='9'){
					stack.push(data[j]-'0');
				}else{
					result = stack.push(stack.pop()+stack.pop());
				}
			}
			
			StringBuilder s = new StringBuilder();
			s.append("#").append(i + 1).append(" ").append(result);
			System.out.println(s);
		}
	}
}
