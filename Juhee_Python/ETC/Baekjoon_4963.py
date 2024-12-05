while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    graph = []
    for i in range(h):
        a = list(map(int, input().split()))
        graph.append(a)

    dx = [-1,1,0,0,-1,-1,1,1]
    dy = [0,0,-1,1,-1,1,-1,1]

    visited = [[0] * w for _ in range(h)]
    count = 0

    queue = []
    answer = []
    def bfs(x, y):
        visited[x][y] = 1
        queue.append([x,y])

        while queue:
            x, y = queue.pop(0)
            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < h and 0 <= ny < w and visited[nx][ny] == 0 and graph[nx][ny] == 1:
                    visited[nx][ny] = 1
                    queue.append([nx,ny])

    for i in range(h):
        for j in range(w):
            if graph[i][j] == 1 and not visited[i][j]:
                bfs(i,j)
                count += 1
    print(count)
