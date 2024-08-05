N = int(input())

apartment = []
stack = []
answer = []

way = [(0,-1), (0,1), (-1,0), (1,0)]

for _ in range(N):
  apartment.append(list(map(int, list(input()))))

cn = 2
for i in range(N):
    for j in range(N):
        visited = []
        if apartment[i][j] == 1:
            stack.append((i,j))
            apartment[i][j] = cn
            visited.append((i,j))
            while stack:
                tx, ty = stack.pop(0)
                for x, y in way:
                  nx = tx + x
                  ny = ty + y
                  if 0 <= nx < N and 0 <= ny < N and apartment[nx][ny] == 1:
                    stack.append((nx, ny))
                    apartment[nx][ny] = cn
                    visited.append((nx, ny))
            cn += 1
            answer.append(len(visited))

print(len(answer))
answer.sort()
for i in answer:
    print(i)

