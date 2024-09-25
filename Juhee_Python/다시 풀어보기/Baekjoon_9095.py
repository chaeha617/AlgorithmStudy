
def function(N):
    dp = [0] * 100001

    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    dp[4] = dp[3] + dp[2] + dp[1]

    for i in range(5, N+1):
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    return dp[N]

T = int(input())
for i in range(T):
    N = int(input())
    result = function(N)
    print(result)
