import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= 10; t++) {
            // Build
            int N = Integer.parseInt(br.readLine());
            int block_size = 100;
            int[] block_array = new int[block_size];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < block_size; i++) {
                block_array[i] = Integer.parseInt(st.nextToken());
            }

            int index_min = 0;
            int index_max = 0;

            // Dump
            for (int n = 0; n < N; n++) {
                index_max = search_index_max(block_array);
                index_min = search_index_min(block_array);
                if (diff_max_min(block_array, index_max, index_min) <= 1) {
                    break;
                }
                block_array[index_max]--;
                block_array[index_min]++;
            }

            // 최고와 최저 차이
            int solution = diff_max_min(block_array, search_index_max(block_array), search_index_min(block_array));

            bw.write("#" + t + " ");
            bw.write(solution + " ");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static int search_index_max(int[] array) {
        int max = 0;
        int index_max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                index_max = i;
            }
        }
        return index_max;
    }

    static int search_index_min(int[] array) {
        int min = 101;
        int index_min = 0;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                index_min = i;
            }
        }
        return index_min;
    }

    static int diff_max_min(int[] array, int max_index, int min_index) {
        int diff = array[max_index] - array[min_index];
        return diff;
    }
}
