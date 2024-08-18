import heapq
import sys
input = sys.stdin.readline
n = int(input())

#데드라인 순으거
heap = []
for _ in range(n):
    a, b = map(int, input().split())
    heapq.heappush(heap, (a, b))

c = 0
time = []

while heap:
    a, b = heapq.heappop(heap) # 가장 작은 데드라인부터
    heapq.heappush(time, b) # 보상 추가
    if len(time) > a: # 데드라인 초과시
        heapq.heappop(time) # 가장 작은 보상 제

c = sum(time)
print(c)