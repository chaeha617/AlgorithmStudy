# 다음에 다시 또 풀어보기... 어렵다
import sys

input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))

dp = [[0] * 21 for _ in range(N)]

dp[0][A[0]] = 1

for i in range(1, N-1):
    for j in range(21):
        if dp[i-1][j]:
            if j + A[i] <= 20:
                dp[i][j+A[i]] += dp[i-1][j]
            if j - A[i] >= 0:
                dp[i][j-A[i]] += dp[i-1][j]

print(dp[N-2][A[-1]])