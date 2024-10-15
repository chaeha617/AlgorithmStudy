N = int(input())

numberList = list(map(int, input().split()))
answer = 0
numberList.sort()

for idx in range(len(numberList)):
    findNum = numberList[idx]
    numlist = numberList.copy()
    numlist.remove(numlist[idx])

    high = len(numlist) - 1
    row = 0

    while row < high:
        num = numlist[row] + numlist[high]
        if findNum == num:
            answer += 1
            break
        elif findNum < num:
            high -= 1
        else:
            row += 1

print(answer)
