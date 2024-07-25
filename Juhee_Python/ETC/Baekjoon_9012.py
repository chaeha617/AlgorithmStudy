T = int(input())
A = []

for i in range(T):
    a = list(input().strip())
    A.append(a)

answer = []

for j in range(T):
    stack = []
    for k in A[j]:
        if stack == []:
            stack.append(k)
        else:
            if k == ')' and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(k)
    if stack == []:
        answer.append("YES")
    else:
        answer.append("NO")

for k in answer:
    print(k)