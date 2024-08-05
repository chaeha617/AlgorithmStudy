'''
def solution(input_string):
    answer = []
    alli = []
    stack = {x: input_string.count(x) for x in list(set(list(input_string)))}

    for al in stack.keys():
        if stack[al] >= 2:
            firfind = input_string.find(al)
            lasfind = input_string.rfind(al)
            if firfind != lasfind:
                answer.append(al)
    alli.append(stack)
    answer.sort()
    return "".join(answer)
'''
def solution(input_string):
    answer = []
    stack = [input_string[0]]
    for al in input_string:
        if stack[-1] !=al:
            stack.append(al)

    for i in set(stack):
        if stack.count(i) >= 2:
            answer.append(i)
    if answer == []:
        return "N"
    answer.sort()
    return "".join(answer)
print(solution("edeaaabbccd"))