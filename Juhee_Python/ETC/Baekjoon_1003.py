import sys
input = sys.stdin.readline
T = int(input().rstrip()) # 테스트 케이스 개수

def fibonacci(N):
    zero = [1,0,1]
    one = [0,1,1]
    if N >= 3:
        for i in range(2, N):
            zero.append(zero[i-1] + zero[i])
            one.append(one[i-1] + one[i])
    print(zero[N], one[N])

for _ in range(T):
    N = int(input())
    fibonacci(N)


# # 시간초과 풀이
# def fibonacci(n):
#     global count0, count1
#     if n == 0:
#         count0 += 1
#         return 0
#     elif n == 1:
#         count1 += 1
#         return 1
#     else:
#         return fibonacci(n-1) + fibonacci(n-2)
#
#
# for i in range(T):
#     a = int(input())
#     count0 = 0
#     count1 = 0
#     fibonacci(a)
#     print(count0, count1)