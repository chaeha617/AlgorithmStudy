find = { "0001101":0, "0011001":1, "0010011":2, "0111101":3, "0100011":4, "0110001":5, "0101111":6, "0111011":7, "0110111":8,
         "0001011":9}

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    l = []
    number = ""

    for i in range(N):
        a = input().strip()
        if '1' in a:
            idx = a.rfind('1')
            number = a[idx-55:idx+1]
            break

    number2 = []
    for i in range(7):
        number2.append(number[:7])
        number = number[7:]

    number2.append(number)

    for i in number2:
        for j, k in find.items():
            if i == j:
                l.append(k)
                continue


    if len(l) != 8:
        print(f"#{test_case} 0")
        break

    answer = 0

    for i in range(8):
        if i % 2 == 0:
            answer += l[i] * 3
        else:
            answer += l[i]


    if answer % 10 == 0:
        print(f"#{test_case} {sum(l)}")
    else:
        print(f"#{test_case} 0")