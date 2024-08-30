A = int(input())
B = list(map(int, input().split()))
dp = [0] * A

dp[0] = B[0]

for i in range(1, A):
    dp[i] = max(B[i], dp[i-1]+B[i])

print(max(dp))