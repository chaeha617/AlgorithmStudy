N = int(input())
dp = [0] * (N+1)

A = []
for i in range(N):
    a = list(map(int, input().split()))
    A.append(a)

A.reverse()
A.insert(0, [])

for j in range(1,N+1):
    if j < A[j][0]:
        dp[j] = dp[j-1]
    else:
        dp[j] = max(dp[j-1], A[j][1] + dp[j-A[j][0]])


print(dp[-1])
# 7
# 3 10
# 5 20
# 1 10
# 1 20
# 2 15
# 4 40
# 2 200