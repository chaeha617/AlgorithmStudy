N = int(input())
graph = []
for i in range(N):
    a = list(map(int, input().rstrip()))
    graph.append(a)

dx = [1,-1,0,0]
dy = [0,0,-1,1]

visited = [0] * (N+1)
answer = []
count = 0
def dfs(x,y):
    global count
    if x >= N or x < 0 or y >= N or y < 0:
        return
    if graph[x][y] == 1:
        count += 1
        graph[x][y] = 0
        for j in range(4):
            ny = y + dy[j]
            nx = x + dx[j]
            dfs(nx, ny)

for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            dfs(i,j)
            answer.append(count)
            count = 0

answer.sort()
print(len(answer))
for i in answer:
    print(i)