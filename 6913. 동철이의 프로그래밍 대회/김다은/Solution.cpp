#include <stdio.h>

int main() {
    int T, N, M;
    scanf("%d", &T);
    for (int t = 0; t < T; t++) {
        scanf("%d %d", &N, &M);
        int winnerCount = 0;
        int maxSum = -1;
        for (int n = 0; n < N; n++) {
            int sum = 0;
            for (int m = 0; m < M; m++) {
                int problem;
                scanf("%d", &problem);
                sum += problem;
            }
            
            if (maxSum < sum) {
                maxSum = sum;
                winnerCount = 1;
            } else if (maxSum == sum){
                winnerCount ++;
            }
        }
        printf("#%d %d %d\n", t+1, winnerCount, maxSum);
    }
    return 0;
}
