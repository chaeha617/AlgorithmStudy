from collections import deque

answer = 0
count = []


def bfs(start, graph, visited):
    queue = deque([start])
    visited[start] = True

    while queue:
        v = queue.popleft()
        next = graph[v]

        if not visited[next]:
            visited[next] = True
            queue.append(next)


T = int(input())  # 테스트 케이스 개수
answer = []
for i in range(T):
    N = int(input())
    A = list(map(int, input().split()))
    # 그래프 구성
    graph = [0] * (N + 1)
    for i in range(N):
        graph[i] = A[i - 1]
    visited = [False] * (N + 1)
    count = 0

    for i in range(1, N + 1):
        if not visited[i]:
            bfs(i, graph, visited)
            count += 1
    answer.append(count)

for i in answer:
    print(i)

# 2
# 8
# 3 2 7 8 1 4 5 6