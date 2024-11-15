from collections import deque
def commandInsert(x, s):
    global textList
    textList = textList[:x] + s + textList[x:]
def commandDelete(x, y):
    global textList
    textList = textList[:x] + textList[x+y:]
def commandAppend(s):
    global textList
    textList = textList + s
T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    textList = list(input().split())
    commandCount = int(input())
    commandList = deque(input().split())

    for _ in range(commandCount):
        operator = commandList.popleft()

        if operator == "A":
            y = int(commandList.popleft())
            s = []
            for add in range(y):
                s.append(commandList.popleft())
            commandAppend(s)
        else:
            x = int(commandList.popleft())
            y = int(commandList.popleft())
            if operator == "I":
                s = []
                for add in range(y):
                    s.append(commandList.popleft())
                commandInsert(x, s)
            elif operator == "D":
                commandDelete(x,y)
            else:
                print("error")

    print("#"+str(test_case),end = " ")
    print(" ".join(textList[:10]))

