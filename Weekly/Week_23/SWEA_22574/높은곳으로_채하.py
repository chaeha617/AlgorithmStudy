T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    maxFloor = 10 ** 9
    N, P = map(int, input().split())
    tot = 0
    for i in range(N + 1):
        tot += i
        if tot == P:
            tot -= 1

    print(tot)