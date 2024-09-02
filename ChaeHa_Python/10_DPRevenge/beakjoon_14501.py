N = int(input())

#배열 인덱스 1부터 시작하기 위한 초기화
counsel = [[0,0]]
dp = [0] * (N+1)

for _ in range(N):
    counsel.append(list(map(int, input().split(" "))))

for i in range(1,N+1):
    day, val = counsel[i]
    val += max(dp[:i])
    day = i + day -1
    if day <= N:
        dp[day] = max(dp[day],val)

print(max(dp))
