# 블랙잭
# N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합 출력

from itertools import combinations

N, M = map(int,input().split())
A = list(map(int, input().split()))

answer = []

for i in combinations(A, 3):
    answer.append(i)

max = 0

for j in answer:
    if sum(j) <= M:
        if sum(j) > max:
            max = sum(j)
    else:
        pass

print(max)