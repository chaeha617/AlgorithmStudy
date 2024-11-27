def solution(n):
    dp = [0] * (n+1)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 1

    for i in range(3, n+1):
        dp[i] = dp[i-1] + dp[i-2]
    print(dp[n] % 1234567)
    return dp[n] % 1234567

solution(3)
solution(4)
solution(5)