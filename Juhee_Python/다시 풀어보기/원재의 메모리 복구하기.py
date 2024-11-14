def solution(a, n, l):
    global count
    le = len(a)
    if n == a or l == le:
        return

    if n[l] != a[l]:
        count += 1
        if n[l] == 0:
            for i in range(l, le):
                n[i] = 1
        else:
            if n[l] == 1:
                for i in range(l, le):
                    n[i] = 0

    solution(a, n, l+1)
    return count

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    count = 0
    a = list(map(int, input().rstrip()))
    n = [0 for i in range(len(a))]
    l = len(a)
    result = solution(a, n, 0)
    print(f"#{test_case} {result}")