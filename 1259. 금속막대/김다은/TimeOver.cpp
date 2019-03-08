#include <stdio.h>
#include <vector>
using namespace std;

struct SCREW {
    int male;
    int female;
};

int N;
bool isEnd = false;

void permutation(int depth, SCREW *screw, int *flag, SCREW *result) {
    if (isEnd){
        return;
    }
    
    if (N == depth) {
        isEnd = true;
        for (int i = 0; i < N - 1; i++) {
            if (result[i].female != result[i + 1].male) {
                isEnd = false;
                break;
            }
        }
        return;
    }
    
    for (int i = 0; i < N; i++) {
        if (isEnd) return;
        if (flag[i] == 1) continue;
        flag[i] = 1;
        result[depth] = screw[i];
        permutation(depth + 1, screw, flag, result);
        flag[i] = 0;
    }
}

int main() {
    int T;
    scanf("%d", &T);
    for (int t = 0; t < T; t++) {
        scanf("%d", &N);
        SCREW screw[N];
        int flag[N];
        SCREW result[N];
        isEnd = false;
        
        for (int n = 0; n < N; n++) {
            int m, f;
            scanf("%d %d", &m, &f);
            screw[n].male = m;
            screw[n].female = f;
            flag[n] = 0;
        }
        
        permutation(0, screw, flag, result);
        
        printf("#%d ", t+1);
        
        for (int i = 0; i < N; i++) {
            printf("%d %d ", result[i].male, result[i].female);
        }
        
        printf("\n");
    }
    
    return 0;
}
