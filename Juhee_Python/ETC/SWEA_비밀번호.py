T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    a, b = map(int, input().split())
    l = []
    for i in str(b):
        l.append(i)

    stack = []

    for i in l:
        if not stack:
            stack.append(i)
        else:
            if stack[-1] == i:
                stack.pop()
            else:
                stack.append(i)

    for i in stack:
        if stack[0] == '0':
            stack.remove(stack[0])

    print(f"#{test_case} {''.join(stack)}")