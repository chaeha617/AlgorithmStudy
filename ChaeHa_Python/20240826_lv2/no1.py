from collections import deque
def solution(grid):
    direction = [(-1,0),(0,1),(1,0),(0,-1)]
    field = [list(x) for x in grid]
    answer = []
    dp = []
    for _i in range(len(grid)):
        _biglist = []
        for _j in range(len(grid[0])):
            _li = []
            for _k in range(4):
                _li.append(-1)
            _biglist.append(_li)
        dp.append(_biglist)


    queue = deque((i,j,k) for k in range(4) for j in range(len(grid[0])) for i in range(len(grid)))
    while queue:
        fx,fy,fdirect = queue.popleft()
        if dp[fx][fy][fdirect] != -1:
            continue
        eage = 0
        x, y, direct = fx,fy,fdirect
        dp[x][y][direct] = eage
        while True:
            if field[x][y] == "R":  # 우회전 direct +1
                direct = (direct + 1) % 4
            elif field[x][y] == "L":  # 좌회전 direct -1
                direct = (direct - 1) % 4
            cx = direction[direct][0]
            cy = direction[direct][1]
            nx = (x + cx) % len(grid)
            ny = (y + cy) % len(grid[0])
            eage += 1

            if dp[nx][ny][direct] != -1:
                answer.append(eage)
                break
            dp[nx][ny][direct] = eage
            x, y = nx, ny

    return sorted(answer)


print(solution(["SL","LR"]))

print(solution(["S"]))
print(solution(["R","R"]))