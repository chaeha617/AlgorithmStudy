N, K = map(int, input().split())
A = []

for i in range(N):
    a = list(map(int, input().split()))
    A.append(a)

A.sort(key=lambda x:(x[1],x[2],x[3]), reverse=True)

idx = [A[i][0] for i in range(N)].index(K)

for i in range(N):
    if A[idx][1:] == A[i][1:]:
        print(i+1)
        break