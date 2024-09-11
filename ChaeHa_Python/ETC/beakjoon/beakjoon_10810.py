N, M = map(int, input().split(" "))
ballList = [0 for _ in range(N)]

for _ in range(M):
    i, j, k = map(int, input().split(" "))
    if i <= j:
        for ballidx in range(i,j+1):
            ballList[ballidx-1] = k
print(*ballList)
