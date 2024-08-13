import sys
input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))

A.sort()
s = 0
for i in range(1,N+1):
    s += sum(A[:N-i+1])

print(s)