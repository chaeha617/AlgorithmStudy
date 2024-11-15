
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, K = map(int, input().split())

    student = [True for _ in range(N)]

    homework = list(map(int, input().split()))

    for stu in homework:
        student[stu - 1] = False

    print("#" + str(test_case),end="")
    for idx, val in enumerate(student):
        if val:
            print(" " + str(idx+1), end="")
    print()
