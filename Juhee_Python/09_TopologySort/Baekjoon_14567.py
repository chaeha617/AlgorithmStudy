import sys
from collections import deque
input = sys.stdin.readline
#
# # 그래프 만들고 위상 정렬
#
# N, M = map(int, input().split())
#
# graph = [[] for _ in range(N+1)]
# result = [0]*(N+1)
# indegree = [0]*(N+1)
#
# for _ in range(M):
#     a, b = map(int, input().split())
#     graph[a].append(b)
#     indegree[b] += 1
#
# queue = deque()
# for i in range(1, N+1):
#     if indegree[i] == 0:
#         queue.append([i,1])
#
# while queue:
#     c, d = queue.popleft()
#     result[c] = d
#     for i in graph[c]:
#         indegree[i] -= 1
#         if indegree[i] == 0:
#             queue.append([i, d+1])
#
# print(result[1:])


N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
indegree = [0]*(N+1)
result = [0]*(N+1)

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    indegree[b] += 1

queue = deque()

for i in range(1, N+1):
    if indegree[i] == 0:
        queue.append([i,1])

while queue:
    c, d = queue.popleft()
    result[c] = d
    for i in graph[c]:
        indegree[i] -= 1
        if indegree[i] == 0:
            queue.append([i, d+1])
print(*result[1:])
