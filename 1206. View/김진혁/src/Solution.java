import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for(int t = 1; t <= 10; t++){
            int[] households = new int[Integer.parseInt(br.readLine())];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i =0; i < households.length; i++){
                households[i] = Integer.parseInt(st.nextToken());
            }

            int view = 0;

            for(int i = 2; i < households.length-2; i++){
                int left = Math.min(households[i]-households[i-1], households[i]-households[i-2]);
                int right = Math.min(households[i]-households[i+1], households[i]-households[i+2]);

                int viewAvailable = Math.min(left,right);

                if(viewAvailable > 0){
                    view += viewAvailable;
                }
            }

            bw.write("#"+t + " " + view + "\n");
        }

        bw.flush();
        bw.close();

    }
}
