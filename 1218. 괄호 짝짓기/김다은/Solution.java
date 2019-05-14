import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        ArrayList<Character> open = new ArrayList<>(Arrays.asList('(','[','{','<'));
        ArrayList<Character> close = new ArrayList<>(Arrays.asList(')',']','}','>'));
 
        for (int t = 1; t <= 10; t++) {
            int length = Integer.parseInt(br.readLine());
            String input = br.readLine();
            int result = 1;
 
            Stack<Character> stack = new Stack<>();
 
            for (int i = 0; i < length; i++) {
                char bracket = input.charAt(i);
                if (open.contains(bracket)) {
                    stack.add(bracket);
                    continue;
                }
 
                char openBracket = stack.pop();
                if (open.indexOf(openBracket) != close.indexOf(bracket)) {
                    result = 0;
                    break;
                }
            }
 
            if (!stack.isEmpty()) result = 0;
 
            bw.append("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }
}
