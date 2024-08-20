import sys
from collections import deque
input = sys.stdin.readline

answer = deque()

N = int(input())
for i in range(N):
    a = list(input().split())
    if a[0] == "push":
        answer.append(a[1])
    elif a[0] == "pop":
        if not answer:
            print(-1)
        else:
            n = answer.popleft()
            print(n)
    elif a[0] == "size":
        print(len(answer))
    elif a[0] == "empty":
        if not answer:
            print(1)
        else:
            print(0)
    elif a[0] == "front":
        if not answer:
            print(-1)
        else:
            print(answer[0])
    else:
        if not answer:
            print(-1)
        else:
            print(answer[-1])