import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int T = 10, testcase, password[] = new int[8];
        for(int i = 1; i <= T; i++){
            testcase = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j<8; j++){
                password[j] = Integer.parseInt(stringTokenizer.nextToken());
            }
            bufferedWriter.write("#"+testcase+" "+toStringPassword(getSuffledPassword(password))+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int[] getSuffledPassword(int[] password){
        int quotient = Integer.MAX_VALUE, negativePassword = 1, index = 0, answer[] = new int[8], temp;
        for(int i = 0; i<8; i++){
            if(password[i]/15 <= quotient){
                quotient = password[i]/15;
                if(password[i]%15 == 0){
                    quotient--;
                }
            }
        }
        for(int i = 0; i<8; i++){
            password[i] = password[i]%(15*quotient);
        }
        while(0 < negativePassword){
            negativePassword = password[index%8] - (index%5 + 1);
            password[index%8] = negativePassword;
            index++;
        }
        for(int i = 0; i<7; i++){
            answer[i] = password[(i+index)%8];
        }
        return answer;
    }

    static String toStringPassword(int[] password){
        String answer = "";
        for(int i : password){
            answer += i+" ";
        }
        return answer;
    }
}
