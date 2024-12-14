
N, M = map(int, input().split())
answer = 0
numberList = list(map(int, input().split()))
for i in range(len(numberList)):
    for j in range(i+1, len(numberList)):
        for k in range(j+1, len(numberList)):
            val = numberList[i] + numberList[j] + numberList[k]
            if val <= M and M - answer > M - val:
                answer = val

print(answer)
