from collections import deque
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    direction = [(1,1),(1,0),(1,-1),(-1,1),(-1,0),(-1,-1)]
    N = int(input())
    field = []
    found = "NO"
    for _ in range(N):
        row = input()
        field.append(row)
        if len(row.replace("ooooo",""))  != len(row):
            found = "YES"

    for row in range(N):
        for col in range(N):
            if field[row][col] != "o":
                continue

            for dx, dy in direction:
                if found == "YES":
                    break
                queue = deque([(row, col, 1)])

                while queue:
                    x, y, stone = queue.popleft()
                    if stone >= 5:
                        found = "YES"
                        break
                    nx = x + dx
                    ny = y + dy

                    if -1 < nx < N and -1 < ny < N and field[nx][ny] == "o":
                        queue.append((nx, ny, stone + 1))
            if found == "YES":
                break
        if found == "YES":
            break

    print("#"+str(test_case), found)

