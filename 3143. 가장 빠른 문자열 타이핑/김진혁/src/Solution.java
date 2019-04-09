import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            char[] A = st.nextToken().toCharArray();
            char[] B = st.nextToken().toCharArray();

            int count = 0;

            for (int i = 0; i < A.length; i++) {
                if (A[i] == B[0]) {
                    i = compareAB(i, A, B);
                }
                count++;
            }

            bw.write("#"+t + " " + count + "\n");
        }

        bw.flush();
        bw.close();



    }

    private static int compareAB(int i, char[] A,  char[] B) {
        if(A.length-i < B.length){
            return i;
        }else{
            int aIterate = i;
            int bIterate = 0;
            while(A[aIterate] == B[bIterate] && bIterate != B.length-1){
                aIterate++;
                bIterate++;
            }

            if(bIterate == B.length-1){
                return aIterate;
            }
        }
        return i;
    }
}