import sys
input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))

d = {}

for i in A:
    if i in d:
        d[i] += 1
    else:
        d[i] = 1

M = int(input())
B = list(map(int, input().split()))



for i in B:
    if i in d:
        print(d[i], end=" ")
    else:
        print(0, end=" ")
