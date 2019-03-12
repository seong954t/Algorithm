import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int number_student = 1000;

        for (int t = 1; t <= T; t++) {
            // Build
            int[] arr_mode = new int[number_student];
            // 배열의 인덱스가 숫자(mode)이고 배열들어가는 값은 나온 횟수
//            for (int i = 0; i < number_student; i++) {
//                arr_mode[i] = 0;
//            }

            int mode_count = 0; // 가장 큰 반복횟수 값
            int mode = 0; // 최빈수

            String no_meaning = br.readLine(); // test numbering. 필요없음
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < number_student; i++) {
                int input_num = Integer.parseInt(st.nextToken());
                arr_mode[input_num]++;
                if (mode_count < arr_mode[input_num]) {
                    mode_count = arr_mode[input_num];
                    mode = input_num;
                } else if (mode_count == arr_mode[input_num] && mode < input_num) {// 같은 경우 mode값 비교
                    mode = input_num;
                }

            }

            StringBuilder s = new StringBuilder();
            s.append("#").append(t).append(" ").append(mode);
            System.out.println(s);

        }
    }
}

