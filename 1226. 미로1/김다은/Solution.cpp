#include <stdio.h>
#include <queue>
using namespace std;

const int di[] = { -1, +1, 0, 0 };
const int dj[] = { 0, 0, -1, +1 };
int size = 16;

int main() {
    int map[size][size];
    int success;
    int testCase;
    
    for (int t = 0; t < 10; t++) {
        scanf("%d", &testCase);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                scanf("%1d", &map[i][j]);
            }
        }
        success = 0;
        int visited[16][16] = { 0, };
        visited[1][1] = 1;
        queue<int> q;
        q.push(101);
        
        while (!q.empty()) {
            int qSize = q.size();
            
            for (int i = 0; i < qSize; i++) {
                int row = q.front()/100;
                int col = q.front()%100;
                q.pop();
                
                if (map[row][col] == 3) {
                    success = 1;
                    break;
                }
                
                for (int d = 0; d < 4; d++) {
                    int nr = row + di[d];
                    int nc = col + dj[d];
                    
                    if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
                    if (map[nr][nc] == 1 || visited[nr][nc] == 1) continue;
                    
                    visited[nr][nc] = 1;
                    q.push(nr*100 + nc);
                }
            }
        }
        printf("#%d %d\n", testCase, success);
    }
    return 0;
}