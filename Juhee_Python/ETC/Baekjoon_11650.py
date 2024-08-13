import sys
input = sys.stdin.readline
N = int(input())

A = []
for i in range(N):
    a = list(map(int, input().split()))
    A.append(a)

A.sort(key = lambda x:(x[0], x[1]))

for i, j in A:
    print(i, j)