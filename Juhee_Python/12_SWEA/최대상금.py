def swap(a, n, visited):
    global mx

    if n == 0:
        now = int(''.join(a))
        mx = max(mx, now)
        return

    state = (tuple(a), n)
    if state in visited:
        return
    visited.add(state)

    for i in range(len(a) - 1):
        for j in range(i + 1, len(a)):
            a[i], a[j] = a[j], a[i]
            swap(a, n - 1, visited)
            a[i], a[j] = a[j], a[i]

T = int(input())
# 여러 개의 테스트 케이스를 처리
for test_case in range(1, T + 1):
    mx = 0
    a, n = map(int, input().split())
    a = list(str(a))
    visited = set()
    swap(a, n, visited)
    print(f"#{test_case} {mx}")
