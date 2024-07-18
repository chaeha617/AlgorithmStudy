from math import factorial

def solution(n, k):

    l = []
    answer = []
    for i in range(1, n+1):
        l.append(i)


    while l != []:
        b = factorial(n) // n  # 맨 앞자리 찾기
        a = k // b
        k = k % b
        if k == 0:
            answer.append(l[a-1])
            l.remove(l[a-1])
        else:
            answer.append(l[a])
            l.remove(l[a])
        n -= 1
    return answer

print(solution(4, 5))