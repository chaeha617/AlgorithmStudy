import heapq

def solution(jobs):
    answer = 0
    time = 0
    jobHeap = []
    joblen = len(jobs)

    #힙 자료구조를 정렬
    for start, run in jobs:
        heapq.heappush(jobHeap, (max(start - time,0), run, start))


    while jobHeap:
        timebool, run, start = heapq.heappop(jobHeap)
        if timebool > 0:
            time = start
        time += run
        answer += time - start
        jobs = jobHeap.copy()
        jobHeap = []
        for _, run, start in jobs:
            heapq.heappush(jobHeap, (max(start - time,0), run, start))

    return answer // joblen


print(solution([[0, 3], [1, 9], [2, 6]]))
