from collections import deque
import sys
input = sys.stdin.readline
N = int(input())
queue = deque()

for i in range(N):
     a = list(map(int, input().split()))

     if len(a) > 1:
          if a[0] == 1:
               queue.appendleft(a[1])
          if a[0] == 2:
               queue.append(a[1])
     else:
          if a[0] == 3:
               if queue:
                    num = queue.popleft()
                    print(num)
               else:
                    print(-1)
          if a[0] == 4:
               if queue:
                    num = queue.pop()
                    print(num)
               else:
                    print(-1)

          if a[0] == 5:
               print(len(queue))

          if a[0] == 6:
               if queue:
                    print(0)
               else:
                    print(1)

          if a[0] == 7:
               if queue:
                    print(queue[0])
               else:
                    print(-1)

          if a[0] == 8:
               if queue:
                    print(queue[-1])
               else:
                    print(-1)