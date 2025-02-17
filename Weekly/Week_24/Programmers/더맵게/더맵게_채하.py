import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while len(scoville) >= 2 and scoville[0] < K:
        first = heapq.heappop(scoville)
        second =  heapq.heappop(scoville)
        heapq.heappush(scoville, first + (second * 2))
        answer += 1
    if scoville[0] < K:
        return -1
    return answer

solution([1,2,3,9,10,12],7)