import heapq
def solution(priorities, location):
    answer = []
    for i in range(len(priorities)):
        heapq.heappush(answer, (-priorities[i], i))
    print(answer)

    count = 1

    while answer:
        a, b = heapq.heappop(answer)
        if b == location:
            break
        else:
            count += 1
    print(count)

    return count

#solution([2, 1, 3, 2], 2)
solution([1, 1, 9, 1, 1, 1], 0)


# 운영체제의 역할 중 하나는 컴퓨터 시스템의 자원을 효율적으로 관리하는 것입니다. 이 문제에서는 운영체제가 다음 규칙에 따라 프로세스를 관리할 경우 특정 프로세스가 몇 번째로 실행되는지 알아내면 됩니다.
#
# 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
# 2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
# 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
#   3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.