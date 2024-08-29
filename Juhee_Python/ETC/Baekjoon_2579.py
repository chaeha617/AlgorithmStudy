
N = int(input())
A = [0] * 301
for i in range(1, N+1):
    a = int(input())
    A[i] = a

dp = [0] * 301
dp[1] = A[1]
dp[2] = A[0] + A[1]
dp[3] = max(A[1] +A[3], A[2]+A[3])

for i in range(4, N+1):
    dp[i] = max(dp[i-3]+A[i-1]+A[i], dp[i-2]+A[i])

print(dp[N])