def function(A, N, L):
    B = [i[1] for i in A]
    answer = []

    count = 0

    for i in range(N):
        if B[i] == L:
            answer.append(A[i][0])
            continue
        else:
            j = i + 1
            while B[i] < L and j < N:
                if B[i] + A[j][1] <= L:
                    B[i] += A[j][1]
                    count += A[j][0]
                j += 1
            answer.append(count)  # 현재 재료의 점수도 포함

    return max(answer) if answer else 0


T = int(input())

for test_case in range(1, T + 1):
    N, L = map(int, input().split())  # 재료의 수, 제한 칼로리

    A = []  # 재료
    for i in range(N):
        T, K = map(int, input().split())  # 점수, 칼로리
        A.append([T, K])

    A.sort(key=lambda x: x[0], reverse=True)  # 점수 내림차순 정렬
    result = function(A, N, L)
    print(f"#{test_case} {result}")
