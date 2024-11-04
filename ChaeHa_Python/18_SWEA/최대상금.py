
def backtraking(numberList, change):
    global maxNumber
    if change <= 0:
        maxNumber = max(maxNumber, int("".join(map(str,numberList))))
    else:
        for idx in range(len(numberList)):
            for changeidx in range(len(numberList)):
                if idx == changeidx:
                    continue
                idxNumber = numberList[idx]
                numberList[idx] = numberList[changeidx]
                numberList[changeidx] = idxNumber
                backtraking(numberList, change - 1)
                idxNumber = numberList[idx]
                numberList[idx] = numberList[changeidx]
                numberList[changeidx] = idxNumber




T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    global maxNumber
    inputList = input().split()

    numberList = list(map(int,inputList[0]))
    change = int(inputList[1])
    maxNumber = -1
    changeNumberList = backtraking(numberList, change)
    print("#"+str(test_case),str(maxNumber))

    # ///////////////////////////////////////////////////////////////////////////////////
#구현 20분