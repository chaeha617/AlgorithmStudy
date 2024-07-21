def solution(m, n, puddles):
    answer = 0
    routeList = [[0 for _ in range(m)] for _ in range(n)]

    for x, y in puddles:
        routeList[x - 1][y - 1] = -1

    routeList[0][0] = 1

    for i in range(n):
        for j in range(m):
            route = routeList[i][j]
            if route <= -1 or i + j == 0:
                continue
            if i <= 0:
                pass
            else:
                route += max(0, routeList[i - 1][j])
            if j <= 0:
                pass
            else:
                route += max(0, routeList[i][j - 1])
            routeList[i][j] = route

    return routeList[n - 1][m - 1]