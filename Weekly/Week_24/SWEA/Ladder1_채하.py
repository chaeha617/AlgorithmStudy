
T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    testNumber = int(input())
    field = []
    direct = [(0,-1),(0,1),(-1,0)]
    visited = [[False for z in range(100)] for v in range(100)]

    for idx in range(100):
        field.append(list(map(int, input().split())))
        if idx == 99:
            start = field[99].index(2)
    move = [99,start]
    visited[99][start] = True

    while move[0] > 0:
        for dx, dy in direct:
            x, y = move
            nx = dx + x
            ny = dy + y
            if 0 <= nx <= 99 and 0 <= ny <= 99:
                if visited[nx][ny]:
                    continue
                if field[nx][ny] == 1:
                    move = [nx,ny]
                    visited[nx][ny] = True
                    break
    print("#"+str(testNumber), str(move[1]))