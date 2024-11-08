from collections import deque

N, M = map(int, input().split())

field = [list(input()) for _ in range(N)]
visited = [[False for __ in range(M)] for _ in range(N)]

direction = [(1,0),(0,1),(-1,0),(0,-1)]

queue = deque()
queue.append((0,0,1))

visited[0][0] = True

while(queue):
    x, y, move = queue.popleft()

    if x == N-1 and y == M-1:
        print(move)
        break

    for directX, directY in direction:
        nx = x + directX
        ny = y + directY

        if -1 < nx < N and -1 < ny < M and field[nx][ny] == '1' and not visited[nx][ny]:
            visited[nx][ny] = True
            queue.append((nx, ny, move +1))
