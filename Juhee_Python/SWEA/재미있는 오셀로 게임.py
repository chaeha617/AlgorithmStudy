def solution(N, M, action):
    graph = [[0] * N for _ in range(N)]
    # 초기화
    graph[N // 2 - 1][N // 2 - 1] = 2
    graph[N // 2 - 1][N // 2] = 1
    graph[N // 2][N // 2 - 1] = 1
    graph[N // 2][N // 2] = 2

    dist = [[-1, -1], [0, -1], [1, -1], [1, 0], [1, 1], [0, 1], [-1, 1], [-1, 0]]

    for i in action:
        x = i[0] -1
        y = i[1] -1
        num = i[2]
        graph[x][y] = num  # 말 놓기

        for i in action:
            x, y, num = i[0] - 1, i[1] - 1, i[2]
            graph[x][y] = num  # 말 놓기
            flip_stones(graph, x, y, num, N, dist)

        count_1 = sum(row.count(1) for row in graph)
        count_2 = sum(row.count(2) for row in graph)
    return count_1, count_2


def flip_stones(graph, x, y, num, N, dist):
    for dx, dy in dist:
        nx, ny = x + dx, y + dy
        stones_to_flip = []

        while 0 <= nx < N and 0 <= ny < N:
            if graph[nx][ny] == 0:
                break
            if graph[nx][ny] == num:
                for fx, fy in stones_to_flip:
                    graph[fx][fy] = num
                break
            stones_to_flip.append((nx, ny))
            nx += dx
            ny += dy


T = int(input())
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    action = []
    for i in range(M):
        a = list(map(int, input().split()))
        action.append(a)
    result = solution(N, M, action)

    print(f"#{test_case} {result[0]} {result[1]}")
