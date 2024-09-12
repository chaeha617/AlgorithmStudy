N = int(input()) # 컴퓨터의 수
A = int(input())

graph = [[0] * (N+1) for _ in range(N+1)]
visited = [0] * (N+1)

for i in range(A):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

answer = []
count = 0
def dfs(V):
    visited[V] = 1
    answer.append(V)
    for i in range(N+1):
        if visited[i] == 0 and graph[V][i] == 1:
            dfs(i)

dfs(1)
print(len(answer)-1)