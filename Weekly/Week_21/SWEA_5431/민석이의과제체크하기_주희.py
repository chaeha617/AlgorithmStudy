T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    A = [i for i in range(1, N+1)]
    B = list(map(int, input().split()))

    for i in B:
        if i in A:
            A.remove(i)

    print(f"#{test_case}", end=" ")
    for i in A:
        if i != A[-1]:
            print(i, end= " ")
        else:
            print(i, end="\n")