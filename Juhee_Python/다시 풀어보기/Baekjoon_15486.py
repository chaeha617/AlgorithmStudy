
import sys

input = lambda: sys.stdin.readline().rstrip()
N = int(input())
A = []

for i in range(N):
    a = list(map(int, input().split()))
    A.append(a)

dp = [0] * (N + 1)

for i in range(N):
    dp[i] = max(dp[i], dp[i - 1])
    if i + A[i][0] <= N:
        dp[i + A[i][0]] = max(dp[i + A[i][0]], dp[i] + A[i][1])

print(max(dp))
