import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] intArray = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            int result = IntStream.of(intArray).sum();

            Arrays.sort(intArray);

            int remainder = N % 3;
            int sale = 0;
            for (int i = remainder; i < N; i=i+3) {
                sale += intArray[i];
            }

            result -= sale;
            bw.append("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }
}