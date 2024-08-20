import sys
from itertools import combinations
input = sys.stdin.readline
a = []
for i in range(9):
    b = int(input())
    a.append(b)

for i in combinations(a, 7):
    if sum(i) == 100:
        answer = list(i)

answer.sort()

for i in answer:
    print(i)