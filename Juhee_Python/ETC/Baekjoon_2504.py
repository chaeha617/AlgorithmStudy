A = list(map(str, input().rstrip()))
stack = []
answer = 0
temp = 1

for i in range(len(A)):
    if A[i] == '(':
        stack.append(A[i])
        temp *= 2
    elif A[i] == '[':
        stack.append(A[i])
        temp *= 3
    elif A[i] == ')':
        if not stack or stack[-1] != '(':
            answer = 0
            break
        if A[i-1] == '(':
            answer += temp
        stack.pop()
        temp //= 2
    elif A[i] == ']':
        if not stack or stack[-1] != '[':
            answer = 0
            break
        if A[i-1] == '[':
            answer += temp
        stack.pop()
        temp //= 3

if stack:
    answer = 0

print(answer)
