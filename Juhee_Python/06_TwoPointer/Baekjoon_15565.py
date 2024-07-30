N, K = map(int, input().split())
a = list(map(int, input().split()))

c = a.count(1)

idx = []
idx2 = []
if c < K:
    print(-1)
else:
    for i in range(N):
        if a[i] == 1:
            idx.append(i) # 인덱스 넣어놓기

    for j in range(len(idx)):
        v = j+K-1 # 개수만큼 인덱스 세서
        if v < len(idx):
            idx2.append(idx[v] - idx[j]+1) # 개수니까 + 1
        else:
            continue
    print(min(idx2)) # 집합 개수가 가장 작은 거 구하기


# 10 2
# 1 2 2 1 2 2 2 2 2 1
#4