from collections import deque

R, C = map(int, input().split(" "))

jihoon = []
fire = []

direction = [(0,-1),(0,1),(-1,0),(1,0)]
queueJihoon = deque()
queueFire = deque()

for row in range(C):
    J = []
    F = []
    for col, ch in enumerate(input()):
        if ch == "J":
            queueJihoon.append((row, col, 0))
            J.append(0)
            F.append(-1)
        elif ch == "F":
            queueFire.append((row, col, 0))
            J.append(-1)
            F.append(0)
        elif ch == ".":
            J.append(-1)
            F.append(-1)
        else:
            J.append(ch)
            F.append(ch)
    jihoon.append(J)
    fire.append(F)

while queueFire:
    fireX, fireY, time = queueFire.popleft()
    for directX, directY in direction:
        fireNX = fireX + directX
        fireNY = fireY + directY
        if 0 <= fireNX and fireNX < R and 0 <= fireNY and fireNY < C:
            if fire[fireNX][fireNY] == -1:
                fire[fireNX][fireNY] = time + 1
                queueFire.append((fireNX,fireNY,time+1))

answer = "IMPOSSIBLE"
while queueJihoon:
    print(queueJihoon)
    jihoonX, jihoonY, time = queueJihoon.popleft()
    if answer != "IMPOSSIBLE":
        break
    for directX, directY in direction:
        jihoonNX = directX + jihoonX
        jihoonNY = directY + jihoonY
        if 0 > jihoonNX or jihoonNX >= R or 0 > jihoonNY or jihoonNY >= C:
            answer = time + 1
            print("answer")
        else:
            if fire[jihoonNY][jihoonNY] =="#":
                continue
            print(fire[jihoonNY][jihoonNY] , time + 1)
            if fire[jihoonNY][jihoonNY] > time + 1:
                jihoon[jihoonNY][jihoonNY] = time + 1
                queueJihoon.append((jihoonNX, jihoonNY, time + 1))
print(fire)
print(jihoon)
print(answer)
