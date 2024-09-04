from collections import deque
def solution(queue1, queue2):
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    cnt = 0
    if (sum(queue1) + sum(queue2)) % 2 == 0:
        for i in range(len(queue1)):
            if sum(queue1) == sum(queue2):
                return cnt
            elif sum(queue1) > sum(queue2):
                queue2.append(queue1.popleft())
            else:
                queue1.append(queue2.popleft())

    return -1