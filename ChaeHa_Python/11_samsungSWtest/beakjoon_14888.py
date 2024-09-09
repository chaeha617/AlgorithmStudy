N = int(input())
numList = list(map(int, input().split()))
# + - * /
operatorList = list(map(int, input().split()))
calList = []

def BT(num, numidx, operLi):
    if numidx >= N:
        calList.append(num)
        return num
    else:
        for idx, oper in enumerate(operLi):
            if oper <= 0:
                continue
            operLi[idx] -= 1
            newNum = num
            if idx == 0:
                newNum += numList[numidx]
            elif idx == 1:
                newNum -= numList[numidx]
            elif idx == 2:
                newNum *= numList[numidx]
            else:
                newNum = int(num / numList[numidx])

            BT(newNum, numidx + 1 , operLi)
            operLi[idx] += 1


BT(numList[0],1,operatorList)
print(max(calList))
print(min(calList))