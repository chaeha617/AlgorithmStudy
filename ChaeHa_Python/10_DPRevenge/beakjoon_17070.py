'''
초기값 : dp(1,2) = 1
점화식 :

'''

N = int(input())
field = []
for _ in range(N):
    field.append(list(map(int,input().split(" "))))

#[가로, 세로, 대각선]
dp = [[[0,0,0] for __ in range(N)]  for _ in range(N)]
dp[0][1][0] = 1

for i in range(N):
    for j in range(N):
        if field[i][j] == 0:
            pipe = 0
            # 가로, 대각선 값 구할때
            if j + 1 < N and field[i][j+1] != 1:
                dp[i][j+1][0] += dp[i][j][0] + dp[i][j][2]

            # 세로, 대각선의 값 구할때
            if i + 1 < N and field[i+1][j] != 1:
                dp[i+1][j][1] += dp[i][j][1] + dp[i][j][2]

            if i + 1 < N and j + 1 < N and field[i+1][j+1] != 1 and field[i][j+1] != 1 and field[i+1][j] != 1:  # 대각선 존재
                dp[i+1][j+1][2] += sum(dp[i][j])

print(sum(dp[N-1][N-1]))
