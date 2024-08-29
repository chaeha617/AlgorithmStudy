T = int(input())

# 0층부터, 1호부터

def function(a, b):
    dp = [0] * (b + 1)
    for i in range(1, b+1): # 0층
        dp[i] += (i + dp[i-1])
    for j in range(1, a):
        for k in range(1, b+1):
            dp[k] += dp[k-1]
    return dp[-1]


for i in range(T):
    a = int(input())
    b = int(input())
    print(function(a,b))
