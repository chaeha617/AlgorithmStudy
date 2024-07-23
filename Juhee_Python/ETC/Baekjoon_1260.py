N, M, V = map(int, input().split())

#행렬 만들기
graph = [[0]*(N+1) for _ in range(N+1)]
for i in range(M):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1


#방문 리스트 행렬
visited1 = [0]*(N+1)
visited2 = visited1.copy()

# dfs
def dfs(V):
    visited1[V] = 1 # 방문처리
    print(V, end=' ')
    for i in range(1, N+1):
        # 노드 V와 연결되어 있고, 방문하지 않은 노드 찾기
        if graph[V][i] == 1 and visited1[i] == 0:
            dfs(i)

# bfs
def bfs(V):
    queue = [V] # 시작 노드 큐에 추가
    visited2[V] = 1 # 방문처리
    while queue: # 큐가 빈다 -> 방문할 노드가 없다
        V = queue.pop(0) # 방문 노드 제거
        print(V, end = ' ')
        for i in range(1, N+1):
            # 노드 V와 연결되어 있고, 방문하지 않은 노드 찾기
            if (visited2[i] == 0 and graph[V][i] == 1):
                queue.append(i)
                visited2[i] = 1

dfs(V)
print()
bfs(V)