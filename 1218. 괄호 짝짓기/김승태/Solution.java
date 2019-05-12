import java.io.*;
import java.util.Stack;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10, N;
        char gh[];
        for(int testcase = 1; testcase <= T; testcase++){
            N = Integer.parseInt(bufferedReader.readLine());
            gh = bufferedReader.readLine().toCharArray();
            bufferedWriter.write("#"+testcase+" "+isCorrectGH(gh, N)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int isCorrectGH(char gh[], int N){
        Stack<Character> stack = new Stack();
        for(int i = 0; i<N; i++){
            if(isClose(gh[i])){
                if(!isCorrectClose(stack, gh[i])){
                    return 0;
                }
            } else{
                stack.push(gh[i]);
            }
        }
        return 1;
    }

    static boolean isClose(char c){
        return c == ')' || c == ']' || c == '}' || c == '>';
    }

    static boolean isCorrectClose(Stack<Character> stack, char c){
        if(stack.isEmpty()){
            return false;
        }
        char stackGH = stack.pop();
        switch (c){
            case ')' :
                return stackGH == '(';
            case ']':
                return stackGH == '[';
            case '}':
                return stackGH == '{';
            case '>':
                return stackGH == '<';
        }
        return false;
    }
}
