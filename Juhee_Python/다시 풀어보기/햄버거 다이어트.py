from itertools import combinations
def solution(a, L):
    mx = 0

    for i in range(1, len(a)+1):
        for j in list(combinations(a, i)):
            a1 = 0
            b1 = 0
            for k in j:
                a1 += k[0]
                b1 += k[1]
            if b1 <= L:
                if a1 > mx:
                    mx = a1
    return mx



T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, L = map(int, input().split())
    a = []

    for i in range(N):
        b = list(map(int, input().split()))
        a.append(b)

    result = solution(a, L)
    print(f"#{test_case} {result}")