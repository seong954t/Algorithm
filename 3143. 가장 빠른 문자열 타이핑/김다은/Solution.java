import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = "", B = "";
            while (st.hasMoreTokens()) {
                A = st.nextToken();
                B = st.nextToken();
            }
            int result = A.length();
            int index = 0;
            boolean check = true;

            for (int i = 0; i < A.length(); i++) {
                if ((A.charAt(i) == B.charAt(index)) && check) {
                    index++;
                    if (index == B.length()){
                        result = result - B.length() + 1;
                        check = false;
                        index = 0;
                    }
                    continue;
                }
                if (A.charAt(i) == B.charAt(0)) {
                    index = 1;
                    check = true;
                    continue;
                }
                check = false;
                index = 0;
            }
            bw.append("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }
}