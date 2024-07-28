M, N = map(int, input().split())
tomato = []
stack = []
way = [(0,-1), (0,1), (-1,0), (1,0)]

for i in range(N):
  tomato.append(list(map(int, input().split())))
  for j in range(M):
    if tomato[i][j] == 1:
      stack.append((i,j))

cn = -1
while stack:
  st = []
  for tx, ty in stack:
    for x, y in way:
      nx = tx + x
      ny = ty + y
      if 0 <= nx < N and 0 <= ny < M and tomato[nx][ny] == 0:
          st.append((nx, ny))
          tomato[nx][ny] = 1
  stack = st
  cn += 1

for i in range(N):
  for j in range(M):
    if tomato[i][j] == 0:
      print(-1)
      exit()
print(cn)
