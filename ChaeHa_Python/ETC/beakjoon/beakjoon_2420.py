N, M = map(int, input().split())
maxVal = max(N,M)
minVal = min(N,M)

if N * M < 0 :
    print(abs(N)+abs(M))
else:
    print(abs(maxVal-minVal))