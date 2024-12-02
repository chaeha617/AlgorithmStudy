N = int(input())
A = list(map(int, input().split()))
A.sort()

if len(A) == 1:
    print(A[0] * A[0])
else:
    print(A[0] * A[-1])