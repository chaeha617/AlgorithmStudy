T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    number = 1
    graph = [[0] * N for _ in range(N)]
    dist = [(0,1), (1,0), (0,-1), (-1,0)]

    x, y = 0, 0
    a = 0

    while number <= N * N:
        graph[x][y] = number
        number += 1
        nx = x + dist[a][0]
        ny = y + dist[a][1]

        if nx < 0 or nx >= N or ny < 0 or ny >= N or graph[nx][ny] != 0:
            a = (a+1) % 4
            nx = x + dist[a][0]
            ny = y + dist[a][1]

        x, y = nx, ny