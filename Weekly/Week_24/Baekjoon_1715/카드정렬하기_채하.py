import heapq
import sys

def cardSort(N):
    answer = 0
    card = []
    heapq.heapify(card)

    for _ in range(N):
        heapq.heappush(card, int(input()))

    if N <= 1 :
        return answer

    while len(card) >= 2:
        val1 = heapq.heappop(card)
        val2 = heapq.heappop(card)
        heapq.heappush(card, val1 + val2)
        answer += val1 + val2
    return answer

input = sys.stdin.readline

N= int(input())
print(cardSort(N))