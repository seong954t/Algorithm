import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T, N, M, score, maxScore, champion;
        T = sc.nextInt();
        long ss = System.currentTimeMillis();
        for(int testcase = 1; testcase<=T; testcase++){
            N = sc.nextInt();
            M = sc.nextInt();
            maxScore = 0;
            champion = 0;
            for(int i = 0; i<N; i++){
                score = 0;
                for(int j = 0; j<M; j++){
                    score += sc.nextInt();
                }
                if(maxScore < score){
                    maxScore = score;
                    champion = 1;
                }else if(maxScore == score){
                    champion++;
                }
            }
            System.out.println(String.format("#%d %d %d", testcase, champion, maxScore));
        }
    }
}
