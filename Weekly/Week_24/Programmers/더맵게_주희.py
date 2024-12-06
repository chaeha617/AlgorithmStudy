import heapq
def solution(scoville, K):
    task = []
    for i in scoville:
        heapq.heappush(task, i)
    count = 0

    while task[0] < K:
        if len(task) < 2:
            return -1
        a = heapq.heappop(task)
        b = heapq.heappop(task)
        heapq.heappush(task, a+(b*2))
        count += 1


    return count

solution([1, 2, 3, 9, 10, 12], 7)