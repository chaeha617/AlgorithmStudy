import sys
input = sys.stdin.readline

a = list(input().rstrip())

answer = []
stack = []

for i in range(len(a)):
    if not stack:
        stack.append(a[i])
    else:
        if a[i] == ')' and stack[-1] == '(':
            stack.pop()
            answer.append(2)
            if a[i-1] == '(' and a[i+1] == ')' or (i < len(a)-1 and a[i+1] == ')') or (i < len(a)-1 and a[i+1] == ']'):
                answer.append("*")
            else:
                if (i < len(a)-1 and a[i+1] == '(') or (i < len(a)-1 and a[i+1] == '['):
                    answer.append("+")
        elif a[i] == ']' and stack[-1] == '[':
            stack.pop()
            answer.append(3)
            if (a[i-1] == '[' and a[i+1] == ']') or (i < len(a)-1 and a[i+1] == ')') or (i < len(a)-1 and a[i+1] == ']'):
                answer.append("*")
            else:
                if (i < len(a) - 1 and a[i + 1] == '(') or (i < len(a) - 1 and a[i + 1] == '['):
                    answer.append("+")
        else:
            stack.append(a[i])




print(answer)