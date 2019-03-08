#include <stdio.h>
#include <list>
#include <queue>
using namespace std;

struct SCREW {
    int male;
    int female;
};

void insertItem(list<SCREW> &screw, queue<SCREW> &q, SCREW newScrew) {
    bool isSuccess = false;
    list<SCREW>::iterator iter;
    
    if (screw.empty()) {
        screw.push_back(newScrew);
        return;
    }
    
    for (iter = screw.begin(); iter!=screw.end(); iter++) {
        
        if (newScrew.female == iter->male) {
            screw.insert(iter, newScrew);
            isSuccess = true;
            break;
        } else if (newScrew.male == iter->female) {
            screw.insert(iter.operator++(), newScrew);
            isSuccess = true;
            break;
        }
    }
    
    if (!isSuccess) {
        q.push(newScrew);
    }
}

int main() {
    int T, N;
    scanf("%d", &T);
    for (int t = 0; t < T; t++) {
        scanf("%d", &N);
        list<SCREW> screw;
        list<SCREW>::iterator iter;
        queue<SCREW> q;
        
        for (int n = 0; n < N; n++) {
            int m, f;
            scanf("%d %d", &m, &f);
            SCREW newScrew = {m, f};
            
            q.push(newScrew);
        }
        
        while (!q.empty()) {
            SCREW newScrew = q.front();
            q.pop();
            insertItem(screw, q, newScrew);
        }
        
        printf("#%d ", t+1);
        
        for (iter = screw.begin(); iter!=screw.end(); iter++) {
            printf("%d %d ", iter->male, iter->female);
        }
        
        printf("\n");
    }
    return 0;
}