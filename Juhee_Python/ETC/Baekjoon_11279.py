import heapq
import sys
input = sys.stdin.readline

n = int(input())
heap = []
for i in range(n):
    a = int(input())
    if a == 0:
        if not heap:
            print(0)
        else:
            n = heapq.heappop(heap)
            print(abs(n))
    else:
        heapq.heappush(heap, -a)

