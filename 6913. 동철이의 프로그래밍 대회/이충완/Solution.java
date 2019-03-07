package com.동철이의_프로그래밍_대회;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int numOfWinners = 1;
            int maxScore = 0;

            for (int i = 0; i < N; i++) {
                int attendeeScore = 0;
                for (int j = 0; j < M; j++) {
                    if (sc.nextInt() == 1)
                        attendeeScore++;
                }
                if (attendeeScore > maxScore) {
                    maxScore = attendeeScore;
                    numOfWinners = 1;
                } else if (attendeeScore == maxScore && i != 0) {
                    numOfWinners++;
                }
            }

            result.append("#").append(tc).append(" ").append(numOfWinners).append(" ").append(maxScore).append("\n");
        }
        System.out.println(result.toString());
        sc.close();
    }
}
