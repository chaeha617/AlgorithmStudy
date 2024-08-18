# 다솜이가 매수해야 하는 사람의 최솟값

import sys
input = sys.stdin.readline

import heapq

N = int(input()) # 후보 수
dasom = int(input())

vote = []
count = 0

for _ in range(N-1):
    n = int(input())
    heapq.heappush(vote, -n)

res = 0
while vote:
    n = -heapq.heappop(vote)
    if dasom > n:
        break
    dasom += 1
    res += 1
    heapq.heappush(vote, -(n-1))
    print(vote)
print(res)