from _collections import deque
import sys
input = sys.stdin.readline

N = int(input())

que = deque()
for _ in range(N):
    command = list(input().split())
    if command[0] == "push":
        que.append(int(command[1]))
    elif command[0] == "size":
        print(len(que))
    elif command[0] == "empty":
        if que:
            print(0)
        else:
            print(1)
    elif not que:
        print(-1)
    elif command[0] == "pop":
        print(que.popleft())
    elif command[0] == "front":
        print(que[0])
    elif command[0] == "back":
        print(que[-1])
