N = int(input())
A = []
for i in range(N):
    a = list(map(int, input().split()))
    A.append(a)



for i in range(1,N):

    for j in range(0, i+1):
        if j == 0:
            A[i][0] += A[i-1][0]
        elif j == i:
            A[i][j] += A[i-1][j-1]
        else:
            A[i][j] += max(A[i-1][j], A[i-1][j-1])

print(max(A[-1]))