N, M = map(int, input().split())

A = []

for _ in range(N):
    A.append(list(map(int, input().split())))

for r in range(N):
    row = list(map(int, input().split()))
    for c in range(M):
        row[c] += A[r][c]
    print(" ".join(map(str, row)))