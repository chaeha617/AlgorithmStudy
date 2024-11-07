def move(command):
    global tank, field
    directIdx = commandDirect.index(command)
    nx = tank[0] + direction[directIdx][0]
    ny = tank[1] + direction[directIdx][1]
    tank[2] = directIdx

    if -1 < nx < H and -1 < ny < W:
        if field[nx][ny] == ".":
            field[tank[0]][tank[1]] = "."
            tank[0] = nx
            tank[1] = ny

    field[tank[0]][tank[1]] = tankDirect[tank[2]]

def shoot():
    global H, W, tank, field
    directIdx = tank[2]
    x = tank[0] + direction[directIdx][0]
    y = tank[1] + direction[directIdx][1]

    while -1 < x < H and -1 < y < W:
        if field[x][y] == "*":
            field[x][y] = "."
            break

        if field[x][y] == "#":
            break

        x = x + direction[directIdx][0]
        y = y + direction[directIdx][1]



T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    H, W = map(int, input().split())
    field = []
    # 위 아래 왼 오
    direction = [(-1,0),(1,0),(0,-1),(0,1)]
    tankDirect = ["^", "v", "<", ">"]
    commandDirect = ["U","D","L","R"]

    for col in range(H):
        row = input()
        field.append(list(row))
        for idx, val in enumerate(row):
            if val in tankDirect:
                tank = [col, idx, tankDirect.index(val)]

    N = int(input())
    commands = list(input())

    for command in commands:
        if command in commandDirect:
            move(command)
        else:
            shoot()

    print("#"+str(test_case),end=" ")

    for row in field:
        print("".join(row))

# 50분 소요

'''
4
2 2
<.
..
12
DDSRRSUUSLLS
3 5
>-#**
.-*#*
.-**#
15
SSSDRSSSDRSSSUU
5 5
v****
*****
*****
*****
*****
44
SSSSDDRSDRSRDSULUURSSSSRRRRDSSSSDDLSDLSDLSSD
3 3
###
#>#
###
2
SS
'''