def row(a, compare):
    compare_copy = compare.copy()
    for j in a:
        if j in compare_copy:
            compare_copy.remove(j)

    if len(compare_copy) == 0:
        return 1
    else:
        return 0

def col(a, compare):
    compare_copy = compare.copy()
    for j in a:
        if j in compare_copy:
            compare_copy.remove(j)

    if len(compare_copy) == 0:
        return 1
    else:
        return 0

def solution(a, compare):
    compare_copy = compare.copy()
    for i in range(3):
        for j in range(3):
            if a[i][j] in compare_copy:
                compare_copy.remove(a[i][j])

    if len(compare_copy) == 0:
        return 1
    else:
        return 0



T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    sudoku = []

    compare = [1,2,3,4,5,6,7,8,9]

    for i in range(9):
        a = list(map(int, input().split()))
        sudoku.append(a)


    # 가로줄 세로줄, 3*3 삼각형들

    answer = []
    # 가로
    for i in range(9):
        result = row(sudoku[i], compare)
        answer.append(result)

    for i in range(9):
        column = [sudoku[j][i] for j in range(9)]
        result = col(column, compare)
        answer.append(result)


    for i in range(0, 9, 3):
        for j in range(0,9,3):
            sub = [row[j:j+3] for row in sudoku[i:i+3]]
            result = solution(sub, compare)
            answer.append(result)


    if 0 in answer:
        print(f"#{test_case} {0}")
    else:
        print(f"#{test_case} {1}")
