N = int(input())
S = []

for _ in range(N):
    s = int(input())
    S.append(s)


def dp(X):
    dp = [0] * 100
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    if 4 <= X:

        for i in range(4, X+1):
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    return dp[X]

for i in S:
    print(dp(i))