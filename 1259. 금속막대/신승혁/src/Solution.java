import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 막대 하나(A)를 기준으로 삼고 그 막대의 암나사의 굵기와 같은 숫나사인 굵기의 막대(B)를 찾는다.
 * 그 막대(B)의 암나사의 굵기와 같은 굵기인 숫나사의 막대(C)를 찾는다   ...
 * 처음 기준 잡은 막대(A)의 숫나사의 굵기와 같은 암나사인 굵기의 막대(D)를 찾는다.
 * 그 막대(D)의 숫나사의 굵기와 같은 굵기인 암나사의 막대(E)를 찾는다  ...
 * */
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());  // 원형 금속 막대 갯수(Bar개수)

            //Build
            Bar[] bars = new Bar[N];    // 원형 금속 막대 배열
            Bar[] connected_bar = new Bar[N];   // 연결한 막대들을 나열한 배열
            StringTokenizer st = new StringTokenizer(br.readLine());
            Bar base_bar = null; //    기준
            Bar compare_bar = null; // 비교 대상
            int index_conn_bar = 0;
            for (int n = 0; n < N; n++) {
                bars[n] = new Bar();
                bars[n].front = Integer.parseInt(st.nextToken());
                bars[n].back = Integer.parseInt(st.nextToken());
                if (n == 0) {
                    base_bar = bars[n];
                    compare_bar = base_bar;
                    connected_bar[index_conn_bar++] = base_bar;
                }
            }

            // 기준을 시작으로 뒤로 연결 가능한 막대들을 찾아 배열에 삽입
            // 1로 시작하는 이유는 첫비교대상의 index가 0이라서
            for (int n = 1; n < N; n++) {
                for (int i = 1; i < N; i++) {
                    if (compare_bar.back == bars[i].front) {
                        Bar find_bar = bars[i];
                        connected_bar[index_conn_bar++] = find_bar;
                        compare_bar = find_bar;
                        break;
                    }
                }
            }
            compare_bar = base_bar;
            // 기준을 시작으로 앞으로 연결가능한 막대들을 찾아 배열에 삽입
            for (int n = 1; n < N; n++) {
                for (int i = 1; i < N; i++) {
                    if (compare_bar.front == bars[i].back) {
                        Bar find_bar = bars[i];
                        System.arraycopy(connected_bar, 0, connected_bar, 1, index_conn_bar);// 0자리 비워주고 하나씩 미루기
                        connected_bar[0] = find_bar;
                        index_conn_bar++;
                        compare_bar = find_bar;
                        break;
                    }
                }
            }

            for (int n = 0; n < N; n++) {
                if (n == 0) {
                    System.out.print("#" + t);
                }
                System.out.print(  " "+connected_bar[n].front + " " + connected_bar[n].back);
            }
            System.out.println();


        }

    }

    private static class Bar {
        public int front; //숫나사 굵기
        public int back;   //암나사 굵기

        public Bar() {
        }
    }
}
