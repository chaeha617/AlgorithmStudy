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
        if i == 0 and j == 1:
            continue
        for direct in range(3):
            if field[i][j] == 0:
                pipe = 0
                if i - 1 > -1 and j - 1 > -1:  # 대각선 존재
                    pipe += dp[i-1][j-1][2]
                # 세로, 대각선의 값 구할때
                if direct != 0 and i - 1 > -1:
                    pipe += dp[i-1][j][1]
                # 가로, 대각선 값 구할때
                if direct != 1 and j - 1 > -1:
                    pipe += dp[i][j-1][0]
                dp[i][j][direct] = pipe

for li in dp:
    print(li)
print(max(dp[N-1][N-1]))
