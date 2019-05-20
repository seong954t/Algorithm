import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= 10; t++) {
            br.readLine();
            String sub = br.readLine();
            String sentence = br.readLine();

            int subIndex = 0;
            boolean check = false;
            int result = 0;
            for (int i = 0; i < sentence.length(); i++) {
                if ((subIndex == 0 || check ) && (sentence.charAt(i) == sub.charAt(subIndex))) {
                    subIndex++;
                    check = true;
                    if (subIndex == sub.length()) {
                        subIndex = 0;
                        check = false;
                        result++;
                    }
                } else if (sentence.charAt(i) == sub.charAt(0)){
                    subIndex = 1;
                    check = true;
                } else {
                    subIndex = 0;
                    check = false;
                }
            }
            bw.append("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }
}
