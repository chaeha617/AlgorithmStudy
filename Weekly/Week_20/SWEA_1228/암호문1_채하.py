from collections import deque
T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    textList = list(input().split())
    commandCount = int(input())
    commandList = deque(input().split())

    for idx in range(commandCount):
        I = commandList.popleft()
        x = int(commandList.popleft())
        y = int(commandList.popleft())
        addText = []
        for cnt in range(y):
            addText.append(commandList.popleft())
        textList = textList[:x] + addText + textList[x:]

    print("#"+str(test_case), end=" ")
    print(" ".join(textList[:10]))
