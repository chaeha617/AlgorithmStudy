from collections import deque

# directions: 상하좌우로 이동하기 위한 좌표
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def zero_one_bfs(grid, N):
    # 덱을 사용해 0-1 BFS 구현
    deque_queue = deque()
    # 복구 시간을 기록할 배열 (최소 경로 가중치를 저장)
    dist = [[float('inf')] * N for _ in range(N)]
    dist[0][0] = 0  # 시작 지점에서의 복구 시간은 0
    deque_queue.append((0, 0))  # 시작 지점 추가

    while deque_queue:
        x, y = deque_queue.popleft()

        # 상하좌우로 이동
        for dx, dy in directions:
            nx, ny = x + dx, y + dy

            # 그리드 안에서만 이동
            if 0 <= nx < N and 0 <= ny < N:
                # 현재 위치에서 다음 위치로 이동할 때의 복구 시간 (0 또는 1)
                new_dist = dist[x][y] + grid[nx][ny]

                # 더 짧은 경로를 발견한 경우 갱신
                if new_dist < dist[nx][ny]:
                    dist[nx][ny] = new_dist
                    # 가중치가 0인 경우 앞에 삽입
                    if grid[nx][ny] == 0:
                        deque_queue.appendleft((nx, ny))
                    # 가중치가 1인 경우 뒤에 삽입
                    else:
                        deque_queue.append((nx, ny))

    # 도착지까지의 최소 복구 시간을 반환
    return dist[N-1][N-1]

# 예시 테스트
N = 4
grid = [
    [0, 1, 0, 0],
    [1, 1, 1, 0],
    [1, 0, 1, 1],
    [1, 0, 1, 0]
]

# 최소 경로 출력
result = zero_one_bfs(grid, N)
print(result)
