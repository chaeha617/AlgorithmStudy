def solution(number, k):
    number = list(number)
    stack = [number[0]]
    for num_idx in range(1,len(number)):
            while len(stack) and stack[-1] < number[num_idx]:
                stack.pop()
                k -= 1
                if k <= 0:
                    stack.extend(number[num_idx:])
                    return ''.join(stack)
            stack.append(number[num_idx])
    return ''.join(stack[:-k])

print(solution("4177252841", 4))