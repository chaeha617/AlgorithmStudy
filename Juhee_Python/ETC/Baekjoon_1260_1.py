N, M, V = map(int, input().split())
graph = [[0] * (N+1) for _ in range(N+1)]

for i in range(M):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

visited = [0] * (N+1)
answer = []

def dfs(V):
    visited[V] = 1
    answer.append(V)
    for i in range(len(graph[V])):
        if graph[V][i] == 1 and not visited[i]:
            dfs(i)

dfs(V)

answer2 = []
visited2 = [0] * (N+1)
def bfs(V):
    queue = [V]
    visited2[V] = 1

    while queue:
        a = queue.pop(0)
        answer2.append(a)
        for i in range(1, N+1):
            if visited2[i] == 0 and graph[a][i] == 1:
                queue.append(i)
                visited2[i] = 1

bfs(V)
print(*answer)
print(*answer2)