
T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    N = int(input())
    field = []
    for _ in range(N):
        field.append(list(input().split()))
    answer = 0
    for col in range(N):
        before = ""
        for row in range(N):
            if field[row][col] == "1":
                before = "1"
            if field[row][col] =="2" and before == "1":
                answer += 1
                before = ""

    print("#"+str(test_case), str(answer))
    # ///////////////////////////////////////////////////////////////////////////////////
