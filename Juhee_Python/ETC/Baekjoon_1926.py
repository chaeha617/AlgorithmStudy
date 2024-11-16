from collections import deque

N, M = map(int, input().split())
graph = []

for i in range(N):
    a = list(map(int, input().split()))
    graph.append(a)

visited = [[0] * M for i in range(N)]
queue = deque()
dist = [(0,-1), (0,1), (1,0), (-1,0)]

def bfs(queue):
    count = 0

    while queue:
        x, y = queue.popleft()
        visited[x][y] = 1
        for i in range(4):
            nx = x + dist[i][0]
            ny = y + dist[i][1]
            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = 1
                queue.append((nx,ny))
        count += 1
    return count


answer = []
for i in range(N):
    for j in range(M):
        if graph[i][j] == 1 and visited[i][j] == 0:
            queue.append((i,j))
            result = bfs(queue)
            answer.append(result)

if answer:
    print(len(answer))
    print(max(answer))
else:
    print(0)
    print(0)