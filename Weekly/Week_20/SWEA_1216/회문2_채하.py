T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    test =input()
    maxLen = 1
    field = []
    fieldReverse = ['' for _ in range(100)]
    for _ in range(100):
        row = input()
        field.append(row)
        for idx, val in enumerate(row):
            fieldReverse[idx] += val
    for row in range(100):
        for col in range(100):
            # 가로 회문 검사하는 로직
            for rowIdx in range(col, 101):
                text = field[row][col:rowIdx]
                if text == text[::-1]:
                    maxLen = max(len(text),maxLen)
            for colIdx in range(row, 101):
                text = fieldReverse[col][row:colIdx]
                if text == text[::-1]:
                    maxLen = max(len(text), maxLen)
    print("#"+str(test),str(maxLen))
