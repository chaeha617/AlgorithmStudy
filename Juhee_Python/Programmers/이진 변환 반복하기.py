def solution(s):
    count1 = 0
    count_zero = 0

    while s != '1':
        count_zero += s.count('0')
        s = s.replace('0', '')
        s = bin(len(s))[2:]
        count1 += 1

    return [count1, count_zero]

print(solution("110010101001"))  # [3, 8]
print(solution("01110"))  # [3, 3]
print(solution("1111111"))  # [0, 0]
