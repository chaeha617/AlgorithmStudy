N = int(input())
count = 0
for i in range(N):
    a = list(input().rstrip())

    stack = []
    for j in a:
        if not stack:
            stack.append(j)
        else:
            if stack[-1] == j:
                stack.pop()
            else:
                stack.append(j)

    if not stack:
        count += 1

print(count)