from collections import deque

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    direction = [(0,1),(1,0),(0,-1),(-1,0)]
    field = [[0 for _ in range(N)]for _ in range(N)]
    change = False
    field[0][0] = 1
    number = 1
    x, y, direct = 0, 0, 0


    while True:
        nx = x + direction[direct][0]
        ny = y + direction[direct][1]
        if -1 < nx < N and -1 < ny < N and field[nx][ny] == 0:
            change = False
            x = nx
            y = ny
            number += 1
            field[x][y] = number
        else:
            if change:
                break
            change = True
            direct = (direct+1) % 4
    print("#"+str(test_case))
    for row in field:
        print(" ".join(map(str,row)))
