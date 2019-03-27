import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        int T, N, price[] = new int[1000001];

        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase<=T; testcase++){
            N = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i = 0; i<N; i++){
                price[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            bufferedWriter.write("#"+testcase+" "+getMoney(N, price)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static long getMoney(int N, int price[]){
        long anser = 0, maxMoney = price[N-1];
        for(int i = N-2; i>=0; i--){
            if(price[i] < maxMoney){
                anser += maxMoney - price[i];
            } else{
                maxMoney = price[i];
            }
        }
        return anser;
    }
}
