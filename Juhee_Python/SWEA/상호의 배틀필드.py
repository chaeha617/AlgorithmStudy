def sangho(field, action, idx, H, W):
    x, y = idx

    for i in action:
        if i == 'U':
            field[x][y] = "^"
            if x - 1 >= 0 and field[x - 1][y] == ".":  # 경계 확인
                field[x][y] = "."
                field[x - 1][y] = "^"
                x -= 1

        elif i == 'D':
            field[x][y] = "v"
            if x + 1 < H and field[x + 1][y] == ".":  # 경계 확인
                field[x][y] = "."
                field[x + 1][y] = "v"
                x += 1

        elif i == 'L':
            field[x][y] = "<"
            if y - 1 >= 0 and field[x][y - 1] == ".":  # 경계 확인
                field[x][y] = "."
                field[x][y - 1] = "<"
                y -= 1

        elif i == 'R':
            field[x][y] = ">"
            if y + 1 < W and field[x][y + 1] == ".":  # 경계 확인
                field[x][y] = "."
                field[x][y + 1] = ">"
                y += 1

        elif i == 'S':
            dx, dy = 0, 0
            if field[x][y] == "^":
                dx, dy = -1, 0
            elif field[x][y] == "v":
                dx, dy = 1, 0
            elif field[x][y] == "<":
                dx, dy = 0, -1
            elif field[x][y] == ">":
                dx, dy = 0, 1


            tx, ty = x + dx, y + dy
            while 0 <= tx < H and 0 <= ty < W:
                if field[tx][ty] == "*":
                    field[tx][ty] = "."
                    break
                elif field[tx][ty] == "#":
                    break
                tx += dx
                ty += dy

    return field


T = int(input())
for test_case in range(1, T + 1):
    H, W = map(int, input().split())
    field = [list(input().rstrip()) for _ in range(H)]
    N = int(input())
    action = input().rstrip()

    idx = None
    for i in range(H):
        for j in range(W):
            if field[i][j] in {"<", ">", "v", "^"}:
                idx = [i, j]
                break
        if idx:
            break

    result = sangho(field, action, idx, H, W)

    print(f"#{test_case}", end=" ")
    for row in result:
        print("".join(row))
