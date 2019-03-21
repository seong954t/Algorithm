import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int T, swapCount;
        char input[];
        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase<=T; testcase++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            input = stringTokenizer.nextToken().toCharArray();
            swapCount = Integer.parseInt(stringTokenizer.nextToken());
            bufferedWriter.write("#"+testcase+" "+getMaxMoney(input, swapCount, 0)+"\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static String getMaxMoney(char input[], int swapCount, int index){
        if(swapCount == 0){
            return new String(input);
        } else if(index == input.length){
            if(swapCount % 2 == 1){
                swap(input, input.length-2, input.length-1);
            }
            return new String(input);
        }
        boolean isSwap = false;
        char maxChar = input[index], tempChar;
        String answer = "0";
        for(int i = input.length-1; i>index; i--){
            if(maxChar < input[i]){
                maxChar = input[i];
            }
        }

        for(int i = input.length-1; i>index; i--){
            if(maxChar == input[i]){
                isSwap = true;
                swap(input, i, index);
                answer = max(getMaxMoney(input, swapCount-1, index+1), answer);
                swap(input, i, index);
            }
        }

        if(!isSwap){
            answer = max(getMaxMoney(input, swapCount, index+1), answer);
        }

        return answer;
    }

    static void swap(char input[], int a, int b){
        char temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    static String max(String a, String b){
        int aa = Integer.parseInt(a);
        int bb = Integer.parseInt(b);
        return aa < bb ? b : a;
    }
}
