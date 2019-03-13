import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10; // 반복횟수

        for (int t = 1; t <= T; t++) {
            int number_building = Integer.parseInt(br.readLine());

            int[] building_array = new int[number_building];
            StringTokenizer heights = new StringTokenizer(br.readLine());
            for (int i = 0; i < number_building; i++) {
                building_array[i] = Integer.parseInt(heights.nextToken());
            }

            int culumative_window = 0;
            for (int i = 2; i < number_building - 2; i++) {
                int now_window = building_array[i];
                int right_window = building_array[i + 1];
                int right_2_window = building_array[i + 2];
                int left_window = building_array[i - 1];
                int left_2_window = building_array[i - 2];
                // 주변 4건물 중 최댓값
                int max_window = Math.max(Math.max(Math.max(right_2_window, right_window), left_2_window), left_window);

                if (max_window >= now_window) { // 5개중 가운데보다 큰 값 존재하면 다음건물
                    continue;
                } else {// 가운데를 제외한 4건물 중 가장 큰 값을 가운데 건물 높이에서 빼줌
                    culumative_window += now_window - max_window;
                }

            }


            bw.write("#" + t + " ");
            bw.write(culumative_window + " ");
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }


}
