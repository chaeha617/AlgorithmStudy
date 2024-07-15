#리스트를 돌면서 뒤의 값이 앞의 값보다 클 경우 앞에서부터 삭제 개수만큼!

def solution(number, k):
    stack = [] # 스택

    for i in number:
        # 스택이 비었을 경우
        if not stack:
            stack.append(i)
            continue
        # 제거해야 할 숫자가 남은 경우
        if k > 0:
            while stack and stack[-1] < i: # 앞 값이 뒤에 값보다 작을 경우
                stack.pop() # 작은 값 지우기
                k -= 1 # 카운트 줄이기
                # 스택이 비었거나 제거 다 했을 경우 루프 종료
                if not stack or k <= 0:
                    break
        # 스택에 현재 값 추가
        stack.append(i)

    # k가 남아있는 경우 마지막 값 제거
    if k > 0:
        stack = stack.pop()
    else:
        pass
    return ''.join(stack)




print(solution("909090", 1))


print(solution("1924",2)) #94
print(solution("1231234",3)) #3234
print(solution("4177252841",4)) #775841

print(solution("654321", 1)) #65432
print(solution( "654321", 5)) #6


print(solution("9929191", 5)) #99

print(solution("91919191", 3)) #99991

print(solution("190000002", 3)) #"900002"
print(solution("179252841", 6)) #984

print(solution("720378", 2)) #7378

print(solution( "6547", 3)) #7
print(solution("999",1))
print(solution("91", 1))

