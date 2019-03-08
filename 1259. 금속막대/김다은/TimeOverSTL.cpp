#include <stdio.h>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    int N, T;
    scanf("%d", &T);
    for (int t = 0; t < T; t++) {
        scanf("%d", &N);
        vector<int> screw;
        
        for (int n = 0; n < N; n++) {
            int m, f;
            scanf("%d %d", &m, &f);
            screw.push_back(m * 100 + f);
        }
        sort(screw.begin(), screw.end());
        
        do {
            bool isEnd = true;
            for (int i = 0; i < N - 1; i++) {
                int female = screw[i] % 100;
                int male = screw[i+1] / 100;
                if (female != male) {
                    isEnd = false;
                    break;
                }
            }
            if (isEnd) {
                break;
            }
        } while (next_permutation(screw.begin(), screw.end()));
        
        printf("#%d ", t+1);
        
        for (int i = 0; i < N; i++) {
            printf("%d %d ", screw[i]/100, screw[i]%100);
        }
        
        printf("\n");
    }
    
    return 0;
}
