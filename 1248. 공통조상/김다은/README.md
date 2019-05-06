# 공통조상
이 문제는 크게 노드 a와 b의 최소 공통 조상 (LCA: Lowest Common Ancestor)을 찾는 부분과 그 LCA의 서브트리의 크기를 구하는 부분으로 나누어 진다.  
문제를 해결하기 위해 데이터를 입력받으면서 트리의 구성을 나타내는 2차원 배열 tree와 각 노드들의 부모를 원소로 갖는 parents 배열을 채워나간다. tree 배열의 tree[n][0 or 1]은 노드 n의 자식 노드를 의미한다.

## LCA 찾기 - findLCA 함수
1. parents 배열을 통해 노드 a와 b 각각의 모든 조상들을 aAncestor와 bAncestor 리스트에 저장한다.
2. contains 함수를 사용하여 aAncestor와 bAncestor에서의 첫 공통 원소를 구하면 그 원소가 최소 공통 조상 이므로 이를 리턴한다.

## 서브트리의 크기
위에서 구한 LCA가 1 즉, 전체 트리의 루트 노드 인 경우 따로 구할 필요 없이 전체 노드의 개수인 v가 구하고자 하는 서브트리의 크기이다. 그렇지 않은 경우에는 countSubtreeSize 함수를 사용하여 서브트리의 크기를 구한다.  
### countSubtreeSize 함수
1. queue에 서브트리의 root 노드(위에서 구한 LCA)의 모든 자식 노드를 add한다.
2. queue에서 원소를 pop한 후, 구하고자 하는 서브트리의 크기인 result를 증가 시켜주고, pop한 원소의 자식 노드를 모두 queue에 넣는 것을 queue가 빌 때까지 반복한다.
--> 이렇게 하면 서브 트리의 노드들을 모두 방문하면서 count하므로 서브트리의 크기를 구할 수 있다.
