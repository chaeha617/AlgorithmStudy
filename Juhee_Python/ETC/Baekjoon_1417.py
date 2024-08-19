import heapq
import sys
input = sys.stdin.readline

N = int(input())
dasom = int(input())

heap = []
count = 0
for i in range(N-1):
    a = int(input())
    heapq.heappush(heap, -a)

while heap:
    n = abs(heapq.heappop(heap))
    if dasom > n:
        break
    else:
        heapq.heappush(heap, -(n-1))
        dasom += 1
        count += 1

print(count)
