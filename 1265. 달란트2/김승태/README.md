# 달란트2

N개의 달란트, P개의 묶음에 대한 입력값이 들어올 경우 각 묶음 당 달란트의 개수들의 곱이 가장 큰 경우를 구하여야 한다.
이를 위해서 N개의 달란트를 P개의 묶음으로 나눌 때 평균 값으로 묶음을 구성할 경우 곱의 크기가 가장 커진다.

따라서, N / P의 몫이 각 묶음 당 달란트의 개수가 된다. 
그러나 이때 N / P의 나머지가 있는 경우 나머지의 값만큼 각 묶음에 달란트를 하나씩 분배해주면 가장 큰 값이 된다.

이를 수식으로 나타내면 아래와 같다.
~~~
(N / P) ^ (P - (N % P)) * ((N / P) + 1) ^ (N % P)
~~~
