import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            ArrayList<Integer> costList = new ArrayList<>(N); //크기 N으로 설정
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int n = 0; n < N; n++) {
                costList.add(Integer.parseInt(st.nextToken()));
            }

            // 내림차순
            costList.sort(new DescendingInteger());

            int solution = 0;
            // 3개로 끊었을 때 맨뒤꺼 안넣음
            // 3개로 끊었을 때 3개가 아닌경우는 다 넣어줌
            for (int i = 0; i < costList.size(); i++) {
                if (i % 3 != 2) {
                    solution += costList.get(i);
                } else if ((i % 3 == 0) && (i == costList.size() - 1 || i == costList.size() - 2)) {
                    solution += costList.get(i);
                }
            }

            bw.write("#" + t + " ");
            bw.write(solution + " ");
            bw.write("\n");
        }
        bw.flush();
        bw.close();


    }

    private static class DescendingInteger implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }
}
