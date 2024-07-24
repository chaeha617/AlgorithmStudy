N = int(input()) # 지도의 크기
graph = []

for i in range(N):
    a = list(map(int, input().rstrip()))
    graph.append(a)

dx = [0,0,-1,1]
dy = [1,-1,0,0]

count = 0
result = []

def dfs(x, y):
    global count
    if x < 0 or x >= N or y < 0 or y >= N:
        return
    if graph[x][y] == 1:
        count += 1
        graph[x][y] = 0 # 방문처리
        for j in range(4):
            nx = dx[j] + x
            ny = dy[j] + y
            dfs(nx,ny)

for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            dfs(i,j)
            result.append(count)
            count = 0

result.sort()

print(len(result))
for i in result:
    print(i)