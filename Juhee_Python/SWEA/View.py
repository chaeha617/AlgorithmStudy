def solution(a):
    answer = 0
    for i in range(2, len(a)-2):
        v = a[i]

        view = []

        view.append(min(min(a[i] -a[i+1], a[i] - a[i+2]),min(a[i] - a[i-2], a[i] - a[i-1])))

        for i in view:
            if i > 0:
                answer += i
    return answer



T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, 11):
    N = int(input())
    a = list(map(int, input().split()))
    a.insert(0, 0)
    a.append(0)
    result = solution(a)
    print(f"#{test_case} {result}")