#시간초과
import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

R, C = map(int, input().split())
A = []
for i in range(R):
    a = list(input().rstrip())
    A.append(a)

dx = [-1,1,0,0]
dy = [0,0,-1,1]
max_count = 0
def dfs(x,y, visited, count):
    global max_count
    max_count = max(max_count, count)

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < R and 0 <= ny < C and A[nx][ny] not in visited:
            dfs(nx, ny, visited + A[nx][ny], count + 1)

dfs(0,0,A[0][0], 1)
print(max_count)