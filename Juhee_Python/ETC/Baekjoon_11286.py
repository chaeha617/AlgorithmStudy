import heapq
import sys
input = sys.stdin.readline
N = int(input())

heap = []

for i in range(N):
    a = int(input())
    if a == 0:
        if not heap:
            print(0)
        else:
            n, m = heapq.heappop(heap)
            print(m)
    else:
        heapq.heappush(heap, (abs(a), a))
