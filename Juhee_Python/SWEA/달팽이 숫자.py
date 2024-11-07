def dfs(N):
    graph = [[0] * N for _ in range(N)]
    dist = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    num = 1
    x, y = 0, -1
    d = 0

    while num <= N * N:
        nx, ny = x + dist[d][0], y + dist[d][1]
        if 0 <= nx < N and 0 <= ny < N and graph[nx][ny] == 0:
            graph[nx][ny] = num
            num += 1
            x, y = nx, ny
        else:
            d = (d + 1) % 4
    return graph

T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    result = dfs(N)

    print(f"#{test_case}")

    for row in result:
        print(*row)
