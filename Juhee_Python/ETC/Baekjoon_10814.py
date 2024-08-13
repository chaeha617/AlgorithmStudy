import sys
input = sys.stdin.readline
N = int(input())
A = []
for i in range(N):
    a,b = list(input().split())
    A.append([int(a), b])

A.sort(key=lambda x:x[0])

for i, j in A:
    print(i, j)