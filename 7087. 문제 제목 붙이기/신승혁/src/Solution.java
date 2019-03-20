import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int solution = 0;

            int C = Integer.parseInt(br.readLine());
            List<Character> alphabetList = new ArrayList<>();
            //char[] alphabetArray = new char[C];
            for (int c = 0; c < C; c++) {
                char inputChar = br.readLine().charAt(0);
                if (isAlpha(inputChar)) { // A~Z만 add
                    alphabetList.add(inputChar);
                }
            }

//            char[5]배열이 하나의 리스트 값으로 들어감.. list.size()=1
//            List<Character> alphabetList = new ArrayList(Arrays.asList(alphabetArray));

            for (int i = 0; i < alphabetList.size(); i++) {
                if (!alphabetList.contains(intToChar(i))) {
                    solution = i;
                    break;
                }
            }

            bw.write("#" + t + " " + solution);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    // 1->A
    private static char intToChar(int i) {
        return (char) (i + 65);
    }

    private static boolean isAlpha(char c) {
        return (c >= 'A' && c <= 'Z');
    }
}
