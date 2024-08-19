import heapq
import sys
input = sys.stdin.readline
heap = []
N = int(input())
for i in range(N):
    a = int(input())
    if a == 0:
        if not heap:
            print(0)
        else:
            n = heapq.heappop(heap)
            print(n)
    else:
        heapq.heappush(heap, a)