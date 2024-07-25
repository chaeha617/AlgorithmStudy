N = int(input())
A = []

for i in range(N):
    a = list(input().split())
    A.append(a)

stack = []

for j in A:
    if len(j) == 2:
        stack.append(j[1])
    else:
        if j[0] == "pop":
            if stack:
                print(stack.pop())
            else:
                print(-1)
        if j[0] == "size":
            print(len(stack))
        if j[0] == "empty":
            if len(stack) == 0:
                print(1)
            else:
                print(0)
        if j[0] == "top":
            if stack:
                print(stack[-1])
            else:
                print(-1)