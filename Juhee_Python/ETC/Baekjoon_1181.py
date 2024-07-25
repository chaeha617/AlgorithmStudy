N = int(input())
A = []
for i in range(N):
    a = list(input().split())
    if a not in A:
        A.append(a)

A.sort(key = lambda x:(len(x[0]), x))

for j in A:
    print(''.join(j))