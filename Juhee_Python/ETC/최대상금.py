def solution(l, visited, b):
    global mx

    if b == 0:
        mx = max(mx, int(''.join(l)))
        return

    if tuple(l) in visited:
        return

    visited.add(tuple(l))

    for i in range(len(l)-1):
        for j in range(i+1, len(l)):
            l[i], l[j] = l[j], l[i]
            solution(l, visited, b-1)
            l[i], l[j] = l[j], l[i]

    return mx



T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    a, b = input().split()
    l = []
    for i in a:
        l.append(i)

    mx = 0
    visited = set()
    result = solution(l, visited, int(b))
    print(f"#{test_case} {result}")