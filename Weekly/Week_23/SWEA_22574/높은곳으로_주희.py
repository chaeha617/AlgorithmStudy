T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, P = map(int, input().split())
    count = 0
    count2 = 0

    for i in range(1, N+1):
        if count + i != P:
            count += i
    for j in range(2, N+1):
        if count2 + j != P:
            count2 += j

    print(max(count, count2))