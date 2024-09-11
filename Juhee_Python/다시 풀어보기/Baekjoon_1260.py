from collections import deque
# 정점 개수, 간선 개수, 탐색 시작 정점 번호
N, M, V = map(int, input().split())

graph = [[0] * (N+1) for _ in range(N+1)]
for i in range(M):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

visited1 = [0] * (N+1)
visited2 = [0] * (N+1)
answer = []

def dfs(V):
    visited1[V] = 1
    answer.append(V)
    for i in range(1, N+1):
        if visited1[i] == 0 and graph[V][i] == 1:
            dfs(i)
    return answer

answer2 = []
def bfs(V):
    queue = deque([V])
    visited2[V] = 1
    while queue:
        a = queue.popleft()
        answer2.append(a)
        for i in range(1, N+1):
            if visited2[i] == 0 and graph[a][i] == 1:
                queue.append(i)
                visited2[i] = 1

dfs(V)
for i in answer:
    print(i, end = " ")
print()
bfs(V)
for i in answer2:
    print(i, end= " ")