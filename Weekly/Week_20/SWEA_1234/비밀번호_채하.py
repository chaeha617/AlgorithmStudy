
T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):

    textLen, text = input().split()

    stack = []

    for ch in text:
        if stack == []:
            stack.append(ch)
        else:
            if stack[-1] == ch:
                stack.pop()
            else:
                stack.append(ch)

    print("#"+str(test_case),"".join(stack))

