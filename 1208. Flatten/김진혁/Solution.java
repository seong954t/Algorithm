import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
 
 
 
 
        for(int t = 1; t <= 10; t++){
            int dump = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] height = new int[101];
 
            for(int i = 1; i < height.length; i++){
                height[Integer.parseInt(st.nextToken())]++;
            }
 
            while(dump != 0) {
 
                for (int i = 0; i < height.length; i++) {
                    if (height[i] != 0) {
                        height[i]--;
                        height[i + 1]++;
                        break;
                    }
                }
 
                for (int i = height.length - 1; i > 0; i--) {
                    if (height[i] != 0) {
                        height[i]--;
                        height[i - 1]++;
                        break;
                    }
                }
 
                --dump;
            }
 
            int min = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] != 0) {
                    min = i;
                    break;
                }
            }
 
            int max =0;
            for (int i = height.length - 1; i > 0; i--) {
                if (height[i] != 0) {
                    max = i;
                    break;
                }
            }
            int answer = max-min;
            bw.write("#"+t + " " + answer + "\n");
 
        }
 
        bw.flush();
        bw.close();
 
 
 
 
 
    }
}
