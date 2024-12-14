import math

N = int(input())
numbers = list(map(int, input().split()))
maxNumber = max(numbers)

numList = [True for _ in range(maxNumber+1)]

answer = 0

numList[0] = False
numList[1] = False

for i in range(2,maxNumber+1):
    if numList[i]:
        for j in range(i*i, maxNumber+1, i):
            numList[j] = False

for number in numbers:
    if numList[number]:
        answer += 1

print(answer)


