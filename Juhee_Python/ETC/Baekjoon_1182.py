from itertools import combinations
import sys
input = sys.stdin.readline
N, S = map(int, input().split())
M = list(map(int, input().split()))

A = [i for i in range(1, N+1)]

count = 0
for j in A:
    for i in list(combinations(M, j)):
        if sum(i) == S:
            count += 1

print(count)