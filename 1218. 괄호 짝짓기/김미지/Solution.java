import java.io.*;
import java.util.Stack;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        int i=1;
        while(i<=10){
            int result=0;
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            for(int j=0; j<N; j++){
                if(input.charAt(j) == '{' || input.charAt(j) =='[' || input.charAt(j)=='(' || input.charAt(j)=='<') stack.push(input.charAt(j));
                else if(stack.peek()=='{' && input.charAt(j)=='}') stack.pop();
                else if(stack.peek()=='[' && input.charAt(j)==']') stack.pop();
                else if(stack.peek()=='(' && input.charAt(j)==')') stack.pop();
                else if(stack.peek()=='<' && input.charAt(j)=='>') stack.pop();
                else stack.push(input.charAt(j));
            }
            if(stack.isEmpty()) result =1;
            bw.write("#" + i + " "+ result+ "\n");
            stack.clear();
            i++;
        }
        bw.close();
    }
}
