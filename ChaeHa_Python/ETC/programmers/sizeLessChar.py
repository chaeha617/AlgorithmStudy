# https://school.programmers.co.kr/learn/courses/30/lessons/147355

def solution(t, p):
    answer = 0
    chlen = len(p)
    for i in range(len(t)-chlen+1):
        print(t[i:i+chlen])
        if int(t[i:i+chlen]) <= int(p):
            answer += 1
    return answer
