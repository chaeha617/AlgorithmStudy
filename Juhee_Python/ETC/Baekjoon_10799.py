import sys
input = sys.stdin.readline

arr = list(input().rstrip())

count = 0
stack = []

for i in range(len(arr)):
    if arr[i] == '(':
        stack.append(arr[i])
    else:
        stack.pop()
        if arr[i-1] == '(':
            count += len(stack)
        else:
            count += 1

print(count)