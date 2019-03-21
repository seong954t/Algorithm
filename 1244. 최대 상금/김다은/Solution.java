import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            String[] numbers = line[0].split("");
            List<String> numberList = new ArrayList<>(Arrays.asList(numbers));
            int N = Integer.parseInt(line[1]);

            int numberLength = numbers.length;
            if (N >= numberLength/2){
                Collections.sort(numberList, Collections.reverseOrder());
                if ((((N - numberLength/2) % 2) == 1)) {
                    Collections.swap(numberList,numberLength-2, numberLength-1);
                }
            } else {
                int left = 0;
                int max;
                int maxIndex = -1;
                while (N > 0) {
                    max = -1;
                    for (int i = numberLength-1; i >= left; i--) {
                        if (max < Integer.parseInt(numberList.get(i))) {
                            maxIndex = i;
                            max = Integer.parseInt(numberList.get(i));
                        }
                    }
                    if (maxIndex != left) {
                        Collections.swap(numberList, left, maxIndex);
                        N--;
                    }
                    left++;
                }
            }
            bw.append("#" + t + " ");
            for (String number : numberList) {
                bw.append(number);
            }
            bw.append("\n");
            bw.flush();

        }
        bw.close();
    }
}