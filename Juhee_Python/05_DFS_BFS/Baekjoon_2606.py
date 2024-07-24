N = int(input()) # 컴퓨터의 수
M = int(input()) # 컴퓨터 쌍의 수

A = [[0] *(N+1) for _ in range(N+1)]


# 행렬 만들기
for i in range(M):
    a, b = map(int, input().split())
    A[a][b] = A[b][a] = 1

visited = [0] * (N+1)
answer = []

def dfs(V):
    visited[V] = 1
    answer.append(V)
    for i in range(N+1):
        if visited[i] == 0 and A[V][i] == 1:
            dfs(i)

dfs(1)
print(len(answer)-1)