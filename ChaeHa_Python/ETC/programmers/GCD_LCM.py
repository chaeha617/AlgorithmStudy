def solution(n, m):
    answer = []
    GCD = 1
    LCM = n * m
    for i in range(2,min(n,m)+1):
        if n % i == 0 and m % i ==0:
            GCD = i

    LCM = GCD * (n / GCD) * (m / GCD)
    return [GCD, LCM]

# 유클리드 호제법 공부 후 다시 풀어보기
#https://school.programmers.co.kr/learn/courses/30/lessons/12940

