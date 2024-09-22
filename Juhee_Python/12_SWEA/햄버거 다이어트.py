from itertools import combinations
def function(A,N,L):
    answer = []

    for i in range(1, N+1):
        for j in list(combinations(A, i)):
            a, b = 0, 0
            for k in range(len(j)):
                a += j[k][0]
                b += j[k][1]
            if b <= L:
                answer.append(a)
    return max(answer)

T = int(input())

for test_case in range(1, T + 1):
    N, L = map(int, input().split())  # 재료의 수, 제한 칼로리

    A = []  # 재료
    for i in range(N):
        T, K = map(int, input().split())  # 점수, 칼로리
        A.append([T, K])

    result = function(A, N, L)
    print(f"#{test_case} {result}")
