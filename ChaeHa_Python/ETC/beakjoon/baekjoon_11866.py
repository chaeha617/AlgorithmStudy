from collections import deque
N, K = map(int, input().split())
numberList = deque([x for x in range(1, N+1)])
answerList = []


while numberList:

    numberList.rotate(-(K-1))
    answerList.append(numberList.popleft())
print("<"+ ", ".join(map(str, answerList))+">")

