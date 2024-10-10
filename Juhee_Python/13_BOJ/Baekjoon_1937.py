import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

N = int(input())
A = [list(map(int, input().split())) for _ in range(N)]
dp = [[-1] * N for _ in range(N)]

dx = [-1,1,0,0]
dy = [0,0,-1,1]

answer = 0

def dfs(x,y):
    if dp[x][y] == -1:
        dp[x][y] = 0

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and A[nx][ny] > A[x][y]:
                dp[x][y] = max(dp[x][y], dfs(nx,ny))

    return dp[x][y] + 1

for i in range(N):
    for j in range(N):
        answer = max(answer, dfs(i,j))

print(answer)
