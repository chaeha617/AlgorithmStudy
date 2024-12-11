import sys
import heapq
input = sys.stdin.readline
n = int(input())
present = []
heapq.heapify(present)

for _ in range(n):
    command = list(map(int, input().split()))
    if command[0] == 0:
        if len(present) <= 0:
            print(-1)
        else:
            print(heapq.heappop(present) * -1)
    else:
        for val in command[1:]:
            heapq.heappush(present,-val)
