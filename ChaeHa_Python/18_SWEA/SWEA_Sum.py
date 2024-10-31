
T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    maxNumber = 0
    field = []
    input()
    for i in range(100):
        row = list(map(int, input().split()))
        field.append(row)
        maxNumber = max(maxNumber, sum(row))

    diagonal = 0
    diagonalReverse = 0

    for i in range(100):
        hight = 0
        for j in range(100):
            if i == j:
                diagonal += field[i][j]
            if i + j == 99:
                diagonalReverse += field[i][j]
            hight += field[j][i]
        maxNumber = max(maxNumber, hight)

    maxNumber = max(diagonalReverse, diagonal, maxNumber)

    print("#"+str(test_case), str(maxNumber))
    # ///////////////////////////////////////////////////////////////////////////////////
