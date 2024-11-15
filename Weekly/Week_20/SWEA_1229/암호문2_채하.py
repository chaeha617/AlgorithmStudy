from collections import deque
def commandInsert(x, s):
    global textList
    textList = textList[:x] + s + textList[x:]

def commandDelete(x, y):
    global textList
    textList = textList[:x] + textList[x+y:]

T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    textList = list(input().split())
    commandCount = int(input())
    commandList = deque(input().split())
    for idx in range(commandCount):
        operator =  commandList.popleft()
        x = int(commandList.popleft())
        y = int(commandList.popleft())
        if operator == "I":
            s = []
            for addIdx in range(y):
                s.append(commandList.popleft())
            commandInsert(x, s)
        if operator == "D":
            commandDelete(x, y)
    print("#"+str(test_case), end=" ")
    print(" ".join(textList[:10]))