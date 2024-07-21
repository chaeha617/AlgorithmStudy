def solution(number, k):
    #문자열로 입력된 값을 리스트로 변환
    number = list(number)
    stack = [number[0]]

    #리스트 순회
    for num_idx in range(1,len(number)):
        #stack이 비어있지 않고, 스택의 마지막 값이 현재 값보다 크거나 같을때 순회
        while len(stack) and stack[-1] < number[num_idx]:
            stack.pop()
            k -= 1
            #더이상 제거할 수 없을때 (k번 만큼 숫자를 제거함)
            if k <= 0:
                stack.extend(number[num_idx:])
                return ''.join(stack)
        #앞에있는 수가 뒤에 있는 수보다 크기때문에 남은 k번만큼 가장 뒤의 수를 제거
        stack.append(number[num_idx])
    return ''.join(stack[:-k])

print(solution("4177252841", 4))