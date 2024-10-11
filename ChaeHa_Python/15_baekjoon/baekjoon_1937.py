'''
N = int(input())

forest = []
forestValue = []
direction = [(0,-1),(0,1),(-1,0),(1,0)]

for _ in range(N):
    forestRow = list(map(int, input().split()))
    forest.append(forestRow)
    forestValue.extend(forestRow)

forestValue = sorted(list(set(forestValue)))

maxMove = 1

for row, valLis in enumerate(forest):
    for col, val in enumerate(valLis):
        if forestValue[-maxMove] > val:
            # DFS
            stack = [(row, col, 1)]
            while stack:
                x, y, move = stack.pop()
                for directX, directY in direction:
                    nx = directX + x
                    ny = directY + y
                    if 0 <= nx and nx < N and 0 <= ny and ny < N:
                        if forest[nx][ny] > forest[x][y]:
                            stack.append((nx, ny, move + 1))
                            maxMove = max(maxMove, move + 1)

print(maxMove)



N = int(input())

forest = []
forestValue = []
direction = [(0,-1),(0,1),(-1,0),(1,0)]

for _ in range(N):
    forestRow = list(map(int, input().split()))
    forest.append(forestRow)
maxMove = 1

for row, valLis in enumerate(forest):
    for col, val in enumerate(valLis):
        # DFS
        stack = [(row, col, 1)]
        while stack:
            x, y, move = stack.pop()
            for directX, directY in direction:
                nx = directX + x
                ny = directY + y
                if 0 <= nx and nx < N and 0 <= ny and ny < N:
                    if forest[nx][ny] > forest[x][y]:
                        stack.append((nx, ny, move + 1))
                        maxMove = max(maxMove, move + 1)

print(maxMove)
'''

'''
N = int(input())

forest = []
forestStack = []
direction = [(0,-1),(0,1),(-1,0),(1,0)]
valSet = set()
for rowIdx in range(N):
    forestRow = list(map(int, input().split()))
    forest.append(forestRow)
    valSet = valSet | set(forestRow)
    for colIdx, value in enumerate(forestRow):
        forestStack.append((value, rowIdx, colIdx))
sortForest = sorted(list(valSet))
forestStack = sorted(forestStack)

maxMove = 1

for idx, values in enumerate(forestStack):
    val, row, col = values
    if sortForest[-maxMove] > val:
        stack = [(row, col, 1)]
        while stack:
            x, y, move = stack.pop()
            for directX, directY in direction:
                nx = directX + x
                ny = directY + y
                if 0 <= nx and nx < N and 0 <= ny and ny < N:
                    if forest[nx][ny] > forest[x][y]:
                        stack.append((nx, ny, move + 1))
                        maxMove = max(maxMove, move + 1)
    else:
        break
print(maxMove)


'''
'''

N = int(input())

forest = []
forestValue = []
direction = [(0,-1),(0,1),(-1,0),(1,0)]
dp = []
for _ in range(N):
    forest.append(list(map(int, input().split())))
    dp.append([-1]for _ in range(N))

for row, valLis in enumerate(forest):
    for col, val in enumerate(valLis):
        # DFS
        stack = [(row, col, 1)]
        maxMove = 1
        while stack:
            x, y, move = stack.pop()
            for directX, directY in direction:
                nx = directX + x
                ny = directY + y
                if 0 <= nx and nx < N and 0 <= ny and ny < N:
                    if forest[nx][ny] > forest[x][y]:

                        stack.append((nx, ny, move + 1))
                        maxMove = max(maxMove, move + 1)

print(maxMove)
'''
'''
import sys
sys.setrecursionlimit(25000)

N = int(input())

forest = []
forestValue = []
direction = [(0,-1),(0,1),(-1,0),(1,0)]
dp = [[-1 for _ in range(N)]for _ in range(N)]

for _ in range(N):
    forest.append(list(map(int, input().split())))


def dfs(x, y):
    global dp
    if dp[x][y] == -1:
        dp[x][y] = 1

    for directX, directY in direction:
        nx = directX + x
        ny = directY + y
        if 0 <= nx and nx < N and 0 <= ny and ny < N:
            if forest[nx][ny] > forest[x][y]:
                if dp[nx][ny] == -1:
                    dfs(nx, ny)
                dp[x][y] = max(dp[x][y], dp[nx][ny] + 1)

for row, valList in enumerate(forest):
    for col, val in enumerate(valList):
        if dp[row][col] > -1:
            continue
        dfs(row, col)

maxMove = 0
for li in dp:
    for val in li:
        maxMove = max(val, maxMove)
print(maxMove)
'''
'''
N = int(input())

forest = []
forestValue = []
direction = [(0,-1),(0,1),(-1,0),(1,0)]
dp = [[-1 for _ in range(N)]for _ in range(N)]

for _ in range(N):
    forest.append(list(map(int, input().split())))

for row, valList in enumerate(forest):
    for col, val in enumerate(valList):
        if dp[row][col] > -1:
            continue
        stack = [(row, col, 1)]
        while stack:
            x, y, move = stack.pop()
            for directX, directY in direction:
                nx = directX + x
                ny = directY + y
                if 0 <= nx and nx < N and 0 <= ny and ny < N:
                    if forest[nx][ny] < forest[x][y]:
                        if dp[nx][ny] == -1:
                            dp[x][y] = 
                        dp[x][y] = max(dp[x][y], dp[nx][ny] + 1)

maxMove = 0
for li in dp:
    for val in li:
        maxMove = max(val, maxMove)
print(maxMove)
'''

N = int(input())

forest = []
forestValue = []
direction = [(0,-1),(0,1),(-1,0),(1,0)]
dp = [[1 for _ in range(N)]for _ in range(N)]
forestList = []
for row in range(N):
    inputrow = list(map(int, input().split()))
    forest.append(inputrow)
    for col, val in enumerate(inputrow):
        forestList.append((val, row, col))

# 숲의 대나무 값을 오름차순으로 정렬
forestList.sort()

maxMove = 1

# 큰수부터 탐색하며 이동가능 칸수 계산
while forestList:
    val, x, y = forestList.pop()
    for directX, directY in direction:
        nx = x + directX
        ny = y + directY
        if 0 <= nx and nx < N and 0 <= ny and ny < N:
            if forest[nx][ny] > forest[x][y]:
                dp[x][y] = max(dp[nx][ny]+1, dp[x][y])
                maxMove = max(dp[x][y], maxMove)

print(maxMove)

