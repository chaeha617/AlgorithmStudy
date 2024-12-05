n = int(input())
N = []
for i in range(n):
    A = list(input().split())
    N.append(A)

N = sorted(N, key=lambda x:(int(x[3]),int(x[2])))
print(N[-1][0])
print(N[0][0])