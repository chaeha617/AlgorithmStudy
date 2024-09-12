import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
N, M = map(int, input().split())

graph = [[0] * (N+1) for _ in range(N+1)]

for i in range(M):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

answer = 0
visited = [0] * (N+1)

def dfs(V):
    global answer
    visited[V] = 1
    for i in range(1, N+1):
        if visited[i] == 0 and graph[V][i] == 1:
            dfs(i)
    return answer


for i in range(1, N+1):
    if not visited[i]:
        dfs(i)
        answer += 1

print(answer)