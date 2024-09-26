import sys
input = sys.stdin.readline

T = int(input().strip())

for i in range(T):
    N = int(input().strip())
    a = bin(N)[2:]
    answer = []
    for j in range(len(a)):
        if a[j] == '1':
            answer.append(len(a) - 1 - j)
    answer.sort()
    for k in answer:
        print(k, end=" ")
    print()