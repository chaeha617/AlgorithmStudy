from collections import deque
import sys
sys.setrecursionlimit(1000)

R, C = map(int, input().split())
graph = []

for i in range(R):
    a = list(input().rstrip())
    graph.append(a)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

fire = deque()
queue2 = deque()

fire_time = [[-1] * C for _ in range(R)]
jihoon_time = [[-1] * C for _ in range(R)]

for i in range(R):
    for j in range(C):
        if graph[i][j] == "F":
            fire.append((i, j))
            fire_time[i][j] = 0
        elif graph[i][j] == "J":
            queue2.append((i, j))
            jihoon_time[i][j] = 0

def bfs_fire():
    while fire:
        x, y = fire.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < R and 0 <= ny < C and graph[nx][ny] != '#' and fire_time[nx][ny] == -1:
                fire_time[nx][ny] = fire_time[x][y] + 1
                fire.append((nx, ny))

def bfs_jihoon():
    while queue2:
        x, y = queue2.popleft()

        if x == 0 or y == 0 or x == R - 1 or y == C - 1:
            return jihoon_time[x][y] + 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < R and 0 <= ny < C:
                if jihoon_time[nx][ny] == -1 and graph[nx][ny] != "#":
                    if fire_time[nx][ny] == -1 or fire_time[nx][ny] > jihoon_time[x][y] + 1:
                        jihoon_time[nx][ny] = jihoon_time[x][y] + 1
                        queue2.append((nx, ny))

    return "IMPOSSIBLE"

bfs_fire()
result = bfs_jihoon()
print(result)
