import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String frog = br.readLine();
            int[] count = new int[5];
            int result = 0;
            for (int i = 0; i < frog.length(); i++) {
                int index;
                if (frog.charAt(i) == 'c') {
                    if (count[4] > 0) {
                        count[4]--;
                    } else result++;
                    count[0]++;
                    continue;
                }
                else if (frog.charAt(i) == 'r') index = 1;
                else if (frog.charAt(i) == 'o') index = 2;
                else if (frog.charAt(i) == 'a') index = 3;
                else index = 4;

                if (count[index-1] == 0){
                    result = -1;
                    break;
                } else {
                    count[index-1]--;
                    count[index]++;
                }
            }
            int sum = count[0] + count[1] + count[2] + count[3];
            if (sum != 0) result = -1;

            bw.append("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }
}