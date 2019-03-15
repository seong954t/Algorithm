import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int dump = Integer.parseInt(br.readLine());
            List<Integer> intArray = Arrays.asList(br.readLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());

            int result = 100;

            while (dump >= 0) {
                int max = Collections.max(intArray);
                int min = Collections.min(intArray);

                result = max - min;

                if (result <= 1) break;

                intArray.set(intArray.indexOf(max), max-1);
                intArray.set(intArray.indexOf(min), min+1);

                dump--;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#");
            sb.append(t);
            sb.append(" ");
            sb.append(result);
            System.out.println(sb);
        }
    }
}
