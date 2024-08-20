import sys
from collections import deque
input = sys.stdin.readline

arr = deque()

N = int(input())

for i in range(N):
    a = list(input().split())
    if a[0] == "push_front":
        arr.appendleft(a[1])
    elif a[0] == "push_back":
        arr.append(a[1])
    elif a[0] == "pop_front":
        if not arr:
            print(-1)
        else:
            print(arr.popleft())
    elif a[0] == "pop_back":
        if not arr:
            print(-1)
        else:
            print(arr.pop())
    elif a[0] == "size":
        print(len(arr))
    elif a[0] == "empty":
        if not arr:
            print(1)
        else:
            print(0)
    elif a[0] == "front":
        if not arr:
            print(-1)
        else:
            print(arr[0])
    else:
        if not arr:
            print(-1)
        else:
            print(arr[-1])