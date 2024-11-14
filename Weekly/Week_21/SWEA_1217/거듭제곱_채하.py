
T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    testNumber = input()
    N, M = map(int, input().split())
    answer = 1
    for _ in range(M):
        answer *= N

    print("#"+str(testNumber), answer)