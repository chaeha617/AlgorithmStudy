from collections import deque

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, M, K = map(int, input().split())
    customers = list(map(int, input().split()))
    customers.sort()
    answer = "Possible"

    for idx, customer in enumerate(customers):
        if (customer // M * K) - (idx + 1) < 0:
            answer = "Impossible"
            break

    print("#"+str(test_case),answer)

