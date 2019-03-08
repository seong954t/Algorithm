#include <stdio.h>
#include <vector>
using namespace std;

struct SCREW {
    int male;
    int female;
};

int N;
bool isEnd = false;

void swap(SCREW *arr, int i, int j) {
    SCREW temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void permutation(int depth, SCREW *screw) {
    if (isEnd){
        return;
    }
    
    if (N == depth) {
        isEnd = true;
        for (int i = 0; i < N - 1; i++) {
            if (screw[i].female != screw[i + 1].male) {
                isEnd = false;
                break;
            }
        }
        if (isEnd) {
            for (int i = 0; i < N; i++) {
                printf("%d %d ", screw[i].male, screw[i].female);
            }
        }
        return;
    }
    
    for (int i = depth; i < N; i++) {
        if (isEnd) return;
        swap(screw, i, depth);
        permutation(depth + 1, screw);
        swap(screw, i, depth);
    }
}

int main() {
    int T;
    scanf("%d", &T);
    for (int t = 0; t < T; t++) {
        scanf("%d", &N);
        SCREW screw[N];
        isEnd = false;
        
        for (int n = 0; n < N; n++) {
            int m, f;
            scanf("%d %d", &m, &f);
            screw[n].male = m;
            screw[n].female = f;
        }
        
        printf("#%d ", t+1);
        
        permutation(0, screw);
        
        printf("\n");
    }
    
    return 0;
}
