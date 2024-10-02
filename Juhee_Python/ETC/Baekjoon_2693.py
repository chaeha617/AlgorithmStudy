import sys
input = sys.stdin.readline
T = int(input())

for i in range(T):
    A = list(map(int, input().split()))
    A.sort(reverse=True)
    print(A[2])

