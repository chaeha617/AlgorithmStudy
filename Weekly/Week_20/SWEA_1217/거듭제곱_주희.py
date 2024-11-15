def solution(a,b):
    num = a
    for i in range(b-1):
        num *= a
    return num

T = 10
for test_case in range(1, T + 1):
    test = int(input())
    a, b = map(int, input().split())
    result = solution(a,b)
    print(f"#{test} {result}")