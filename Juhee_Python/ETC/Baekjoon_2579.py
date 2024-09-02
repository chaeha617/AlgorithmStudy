import sys
input = sys.stdin.read

data = input().split()

N = int(data[0])

stair = [0] * (N + 1)
for i in range(1, N + 1):
    stair[i] = int(data[i])

dp = [0] * (N + 1)

if N >= 1:
    dp[1] = stair[1]
if N >= 2:
    dp[2] = stair[1] + stair[2]
if N >= 3:
    dp[3] = max(stair[1] + stair[3], stair[2] + stair[3])

for i in range(4, N + 1):
    dp[i] = max(dp[i - 3] + stair[i - 1] + stair[i], dp[i - 2] + stair[i])

print(dp[N])
