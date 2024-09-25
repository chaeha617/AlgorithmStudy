def function(A, B):
    C = A + B
    if C >= 24:
        C -= 24
    return C

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    A, B = map(int, input().split())
    result = function(A,B)
    print(f"#{test_case} {result}")