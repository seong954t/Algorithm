import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc = 1; tc <= 10; tc++) {
            int length = Integer.parseInt(br.readLine());
            char[] arr = br.readLine().toCharArray();

            int bracket_1 = 0, bracket_2 = 0, bracket_3 = 0, bracket_4 = 0;
            boolean isStop = false;
            breakOut:
            for (int i = 0; i < length; i++) {
                switch (arr[i]) {
                    case '(':
                        bracket_1++;
                        break;
                    case ')':
                        if (bracket_1 == 0) {
                            isStop = true;
                            break breakOut;
                        } else {
                            bracket_1--;
                        }
                        break;
                    case '{':
                        bracket_2++;
                        break;
                    case '}':
                        if (bracket_2 == 0) {
                            isStop = true;
                            break breakOut;
                        } else {
                            bracket_2--;
                        }
                        break;
                    case '[':
                        bracket_3++;
                        break;
                    case ']':
                        if (bracket_3 == 0) {
                            isStop = true;
                            break breakOut;
                        } else {
                            bracket_3--;
                        }
                        break;
                    case '<':
                        bracket_4++;
                        break;
                    case '>':
                        if (bracket_4 == 0) {
                            isStop = true;
                            break breakOut;
                        } else {
                            bracket_4--;
                        }
                        break;
                    default:
                        break;
                }
            }
            if (isStop || (bracket_1 + bracket_2 + bracket_3 + bracket_4) != 0) {
                bw.write("#" + tc + " 0\n");
            } else {
                bw.write("#" + tc + " 1\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
