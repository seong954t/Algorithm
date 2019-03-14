import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            br.readLine();
            String[] scores = br.readLine().split(" ");
            int[] count = new int[101];

            for (int i = 0; i < scores.length; i++) {
                int index = 100 - Integer.parseInt(scores[i]);
                count[index]++;
            }

            Integer countInteger[] = Arrays.stream(count).boxed().toArray(Integer[]::new);
            System.out.print("#" + (t+1) + " ");
            List<Integer> list = Arrays.asList(countInteger);
            IntStream.range(0, list.size())
                    .reduce((a,b) -> list.get(a) < list.get(b) ? b:a)
                    .ifPresent(idx -> System.out.println(100 - idx));
        }
    }
}