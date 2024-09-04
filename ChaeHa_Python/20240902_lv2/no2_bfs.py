from collections import deque
def solution(queue1, queue2):
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    cnt = 0
    que = deque([(queue1,queue2,0),(queue2,queue1,0)])
    test = []
    test.extend(queue1)
    test.extend(queue2)
    test.sort()
    if sum(test) % 2 != 0:
        return -1

    num1 = 0
    num2 = 0
    test = deque(test)
    for _ in range(len(queue1)//2):
        num1 += test.pop()
        num2 += test.pop()
        num1 += test.popleft()
        num2 += test.popleft()
    if num2 != num1:
        return -1
    while que:
        qu1, qu2, cn = que.popleft()
        if sum(qu1) == sum(qu2):
            return cn
        if cn > len(queue1)*2:
            return -1
        if not qu2:
            qu1.append(qu2.popleft())
        cn += 1
        que.append((qu1, qu2, cn))
        que.append((qu2, qu1, cn))

    return -1

print(solution([3, 2, 7, 2], [4, 6, 5, 1]))