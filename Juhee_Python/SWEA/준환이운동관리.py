T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    L, U, X = map(int, input().split())

    a = X - L

    if X > U:
        print(f"#{test_case} -1")
    elif L <= X <= U:
        print(f"#{test_case}", 0)
    else:
        print(f"#{test_case}", abs(a))
