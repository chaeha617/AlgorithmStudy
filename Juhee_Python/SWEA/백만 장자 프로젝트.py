def solution(a):
    mx = 0
    answer = 0

    for i in a[::-1]:
        if i > mx:
            mx = i
        else:
            answer += mx - i
    return answer

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())  # 개수
    a = list(map(int, input().split()))  # 금액
    result = solution(a)
    print(f"#{test_case} {result}")
