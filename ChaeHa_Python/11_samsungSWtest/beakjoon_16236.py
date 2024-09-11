#상하좌우
direct = [(-1,0),(1,0),(0,1),(0,-1)]
N = int(input())
field = []
stack = []
for i in range(N):
    row = list(map(int, input().split(" ")))
    if 9 in row:
        shark = (i, row.index(9))
    field.append(row)
stack.append(shark, field, 0)

while stack:
    shark, nowField, time = stack.pop()

