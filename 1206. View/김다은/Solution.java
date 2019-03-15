import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            int size = Integer.parseInt(br.readLine());
            String[] strArray = br.readLine().split(" ");
            int[] intArray = Arrays.asList(strArray).stream().mapToInt(Integer::parseInt).toArray();

            int result = 0;

            for (int i = 2; i < size - 2; i++) {
                int current = intArray[i];
                if (intArray[i] == 0) continue;
                if (intArray[i-2] >= current || intArray[i-1] >= current ||
                        intArray[i+1] >= current || intArray[i+2] >= current) continue;

                int max = Collections.max(Arrays.asList(intArray[i-2], intArray[i-1], intArray[i+1], intArray[i+2]));
                result = result + current - max;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#");
            sb.append(t+1);
            sb.append(" ");
            sb.append(result);
            System.out.println(sb);
        }
    }
}