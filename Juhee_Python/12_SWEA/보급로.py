from collections import deque

dx = [-1,1,0,0]
dy = [0,0,-1,1]



def bfs(N, graph):
    dist = [[float('inf')] * N for _ in range(N)]
    dist[0][0] = graph[0][0]

    dq = deque([(0,0)])
    while dq:
        x, y = dq.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                new_dist = dist[x][y] + graph[nx][ny]
                if new_dist < dist[nx][ny]:
                    dist[nx][ny] = new_dist

                    if graph[nx][ny] == 0:
                        dq.appendleft((nx,ny))
                    else:
                        dq.append((nx,ny))
    return dist[N-1][N-1]


T = int(input())  # 테스트 케이스 수
for tc in range(1, T + 1):
    N = int(input())
    graph = []
    for i in range(N):
        a = list(map(int, input().rstrip()))
        graph.append(a)

    result = bfs(N, graph)
    print(f"#{tc} {result}")
