memo = {}

def solution(a, b, c):
    if (a, b, c) in memo:
        return memo[(a, b, c)]

    if a <= 0 or b <= 0 or c <= 0:
        result = 1

    elif a > 20 or b > 20 or c > 20:
        result = solution(20, 20, 20)

    elif (a < b) and (b < c):
        result = solution(a, b, c - 1) + solution(a, b - 1, c - 1) - solution(a, b - 1, c)

    else:
        result = solution(a - 1, b, c) + solution(a - 1, b - 1, c) + solution(a - 1, b, c - 1) - solution(a - 1, b - 1, c - 1)

    memo[(a, b, c)] = result
    return result


while True:
    a, b, c = map(int, input().split())

    if a == -1 and b == -1 and c == -1:
        break

    result = solution(a, b, c)
    print(f"w({a}, {b}, {c}) = {result}")
