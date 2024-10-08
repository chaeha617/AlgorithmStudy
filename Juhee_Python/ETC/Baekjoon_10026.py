import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

N = int(input())
A = []
A2 = []

for i in range(N):
    a = list(input().rstrip())
    A.append(a)
    A2.append([color for color in a])


for i in range(N):
    A2[i] = [color.replace('G', 'R') for color in A2[i]]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

visited = [[0] * N for _ in range(N)]
visited2 = [[0] * N for _ in range(N)]

count = 0
count2 = 0


def dfs(x, y):
    visited[x][y] = 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and A[nx][ny] == A[x][y]:
            dfs(nx, ny)

def dfs2(x, y):
    visited2[x][y] = 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < N and not visited2[nx][ny] and A2[nx][ny] == A2[x][y]:
            dfs2(nx, ny)

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            dfs(i, j)
            count += 1

for i in range(N):
    for j in range(N):
        if not visited2[i][j]:
            dfs2(i, j)
            count2 += 1

print(count, count2)
