from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
queue = deque()

for i in range(N):
    a = list(input().split())

    if len(a) > 1:
        queue.append(a[1])
    else:
        if a[0] == "pop":
            if queue:
                num = queue.popleft()
                print(num)
            else:
                print(-1)

        if a[0] == "size":
            print(len(queue))

        if a[0] == "empty":
            if not queue:
                print(1)
            else:
                print(0)

        if a[0] == "front":
            if queue:
                print(queue[0])
            else:
                print(-1)

        if a[0] == "back":
            if queue:
                print(queue[-1])
            else:
                print(-1)
