
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    # 위, 대각선, 오른쪽, 대각선, 아래, 대각선, 왼쪽, 대각선
    direction = [(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1),(0,-1),(-1,-1)]
    field = [[0 for i in range(N+1)] for j in range(N+1)]

    field[N // 2 + 1][N // 2 + 1] = 2
    field[N // 2][N // 2] = 2
    field[N // 2][N // 2 + 1] = 1
    field[N // 2 + 1][N // 2] = 1


    for _ in range(M):
        x, y, color = map(int, input().split())
        field[x][y] = color
        for directX, directY in direction:
            nx = x + directX
            ny = y + directY
            if 0 < nx < N + 1 and 0 < ny < N + 1:
                if field[nx][ny] != color and  field[nx][ny] != 0:
                    change = []
                    change.append((nx,ny))
                    while (True):
                        nx = nx + directX
                        ny = ny + directY
                        if 0 < nx < N+1 and 0 < ny < N+1:
                            if field[nx][ny] == color:
                                break
                            if field[nx][ny] == 0:
                                change = []
                                break
                            if field[nx][ny] != color and field[nx][ny] != 0:
                                change.append((nx, ny))

                        else:
                            change = []
                            break

                    for changeX, changeY in change:
                        field[changeX][changeY] = color

    answer = [0,0]
    for row in field:
        answer[0] += row.count(1)
        answer[1] += row.count(2)
    print("#"+str(test_case),answer[0],answer[1])

#48분 소요