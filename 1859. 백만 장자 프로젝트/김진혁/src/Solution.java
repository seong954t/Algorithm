import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Queue<Long> price = new LinkedList<>();


            for(int n = 0; n < N; n++){
                price.add(Long.parseLong(st.nextToken()));
            }

            long money = 0;
            int count = 0;

            long maxValue = Collections.max(price);

            while(!price.isEmpty()){

                if(maxValue == price.peek()){
                    money += count * price.poll();
                    if(!price.isEmpty()) {
                        maxValue = Collections.max(price);
                    }
                    count = 0;
                }else{
                    money -= price.poll();
                    count++;
                }

            }
            bw.write("#"+t +" " + money + "\n");

        }

        bw.flush();
        bw.close();
    }
}