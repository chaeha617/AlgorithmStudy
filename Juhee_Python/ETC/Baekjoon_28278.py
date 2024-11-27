import sys
input = sys.stdin.read

data = input().splitlines()
N = int(data[0])

stack = []

for i in range(1, N + 1):
    command = data[i]
    if command.startswith("1"):
        _, num = command.split()
        stack.append(int(num))
    elif command == "2":
        if stack:
            print(stack.pop())
        else:
            print(-1)
    elif command == "3":
        print(len(stack))
    elif command == "4":
        print(1 if not stack else 0)
    elif command == "5":
        if stack:
            print(stack[-1])
        else:
            print(-1)
