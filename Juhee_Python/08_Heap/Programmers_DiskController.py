import heapq

def solution(jobs):
    l = len(jobs)
    count, answer, time = 0, 0, 0

    heap = []

    # jobs를 도착 시간으로 정렬
    jobs.sort()

    while count < l:

        # 현재 시간까지 도착한 모든 작업을 heap에 추가
        while jobs and jobs[0][0] <= time:
            arrival, duration = jobs.pop(0)
            heapq.heappush(heap, (duration, arrival))

        if heap:
            # 작업 시간(duration)이 가장 짧은 작업을 선택
            duration, arrival = heapq.heappop(heap)
            time += duration
            answer += (time - arrival)
            count += 1
        else:
            # 처리할 작업이 없으면 시간 이동
            time = jobs[0][0]

    return answer // l

# 테스트 케이스
print(solution([[0, 3], [1, 9], [2, 6]]))
