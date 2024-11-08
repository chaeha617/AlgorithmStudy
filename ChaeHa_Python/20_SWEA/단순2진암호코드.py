from collections import deque
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    code = ["0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"]

    N, M = map(int, input().split())
    pwRow = 0
    pw = ""
    for _ in range(N):
        row = input()
        if row.count("1") >= 1:
            if pw == "":
                pw = row

            if pw != row:
                pw = "no answer"

            pw = row
            pwRow += 1

    if pw == "no answer":
        answer = 0
    else:
        firstOne = pw.find("1")
        pw = pw[firstOne:firstOne+56]
        pw = list(pw)
        zero = []
        for idx in range(55,0,-1):
            if pw[idx] == "1":
                break
            zero += pw.pop()
        pw = zero + pw
        pw = deque(pw)

        numbers = []
        for i in range(8):
            number = []
            for j in range(7):
                number += pw.popleft()
            number = "".join(number)

            numbers.append(code.index(number))

        odd = 0
        even = 0
        for idx, val in enumerate(numbers):
            if (idx + 1) % 2 == 0:
                even += val
            else:
                odd += val

        if ((odd * 3) + (even)) % 10 == 0:
            answer = sum(numbers)
        else:
            answer = 0
    print("#"+str(test_case),str(answer))

