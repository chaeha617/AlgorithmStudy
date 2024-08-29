N = int(input())

counsel = []
dp = [0]* N

for _ in range(N):
    counsel.append(list(map(int, input().split(" "))))

dp[1] = 1
print(dp)