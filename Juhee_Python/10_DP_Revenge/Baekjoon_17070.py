# 벽이 막히는 경우 제외

# 가로 2, 세로 2, 대각선 3

# 가로는 왼쪽 가로 + 왼쪽 대각선
# 세로는 위쪽 세로  + 위쪽 대각선
# 대각선은 왼쪽 위 가로 세로 대각선

N = int(input())
A = []

for i in range(N):
    a = list(map(int, input().split()))
    A.append(a)

dp = [[[0 for _ in range(N)] for _ in range(N)] for _ in range(3)]
# dp 가로, 대각선, 세로 순

dp[0][0][1] = 1 # 초기 파이프

for  i in range(2, N):
    if A[0][i] == 0: # 0행 가로 파이프
        dp[0][0][i] = dp[0][0][i-1]

for j in range(1, N):
   for k in range(1, N):
       if A[j][k] == 0:
           if A[j][k] == 0 and A[j][k-1] == 0 and A[j-1][k] == 0: # 대각선
               dp[1][j][k] = dp[0][j-1][k-1] + dp[1][j-1][k-1] + dp[2][j-1][k-1]
           dp[0][j][k] = dp[0][j][k-1] + dp[1][j][k-1]
           dp[2][j][k] = dp[2][j-1][k] + dp[1][j-1][k]

print(dp[0][N-1][N-1] + dp[1][N-1][N-1] + dp[2][N-1][N-1])