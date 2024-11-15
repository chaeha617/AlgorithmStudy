from itertools import combinations

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    a = list(map(int, input().split()))

    for i in a:
        if i > K:
            a.remove(i)

    count = 0

    for i in range(1, N+1):
        for j in list(combinations(a, i)):
            if sum(j) == K:
                count += 1

    print(f"#{test_case} {count}")