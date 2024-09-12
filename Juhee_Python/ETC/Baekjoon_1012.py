import sys
sys.setrecursionlimit(10**6)

T = int(input())

def dfs(x, y):
    if x < 0 or x >= M or y < 0 or y >= N:
        return
    if graph[y][x] == 1:
        graph[y][x] = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            dfs(nx, ny)

for _ in range(T):
    M, N, K = map(int, input().split())
    graph = [[0] * M for _ in range(N)]

    for _ in range(K):
        a, b = map(int, input().split())
        graph[b][a] = 1

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    answer = 0

    for y in range(N):
        for x in range(M):
            if graph[y][x] == 1:
                dfs(x, y)
                answer += 1

    print(answer)
