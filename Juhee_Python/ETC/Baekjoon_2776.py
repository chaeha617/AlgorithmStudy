import sys
input = sys.stdin.readline
T = int(input())

for i in range(T):
    N = int(input())
    A = list(map(int, input().split()))
    M = int(input())
    B = list(map(int, input().split()))

    A.sort()
    A_set = set(A)
    answer = []

    for target in B:
        if target in A_set:
            answer.append(1)
        else:
            answer.append(0)

    for k in answer:
        print(k)
