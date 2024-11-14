
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    numbers = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
    numberCount = ['' for _ in range(10)]

    testNumber, lenText = input().split()
    textList = input().split()
    for val in textList:
        idx = numbers.index(val)
        if numberCount[idx] == '':
            numberCount[idx] = numbers[idx]
        else:
            numberCount[idx] = numberCount[idx] + " " + numbers[idx]
    text = ''
    for idx, cnt in enumerate(numberCount):
        text = " ".join(numberCount)

    print(testNumber)
    print(text)