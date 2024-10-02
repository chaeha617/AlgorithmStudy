def solution(N, A):
    count = 0
    for i in range(len(N)):
        if N[i] == A[i]:
            continue
        else:
            for j in range(i, len(N)):
                A[j] = N[i]
            count += 1
    return count

T = int(input())
for test_case in range(1, T + 1):
    N = list(map(int, input().rstrip()))
    A = [0 for _ in range(len(N))]
    result = solution(N, A)
    print(f"#{test_case} {result}")