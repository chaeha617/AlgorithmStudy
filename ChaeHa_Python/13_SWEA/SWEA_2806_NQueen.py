T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    n = int(input())
    check_col = [False] * ((n + 1) * 2)
    check_d1 = [False] * ((n + 1) * 2)
    check_d2 = [False] * ((n + 1) * 2)
    def process(row):
        answer = 0
        if row == n + 1:
            return 1
        for i in range(1, n + 1):
            d1 = row + i
            d2 = n + (row - i)
            if check_col[i] == False and check_d1[d1] == False and check_d2[d2] == False:
                check_col[i] = True
                check_d1[d1] = True
                check_d2[d2] = True
                answer += process(row + 1)
                check_col[i] = False
                check_d1[d1] = False
                check_d2[d2] = False
        return answer

    print("#"+str(test_case),str(process(1)))

    # ///////////////////////////////////////////////////////////////////////////////////
