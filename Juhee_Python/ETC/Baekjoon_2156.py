N = int(input())

A = []

for i in range(N):
    a = int(input())
    A.append(a)

dp = [0] * (N+1)
dp[0] = A[0]

if N > 1:
    dp[1] = A[0] + A[1]
if N > 2:
    dp[2] = max(A[2]+A[1], A[0]+A[2], dp[1])

for i in range(3, N):
    dp[i] = max(dp[i-1], dp[i-3]+A[i-1]+A[i], dp[i-2]+A[i])

print(max(dp))