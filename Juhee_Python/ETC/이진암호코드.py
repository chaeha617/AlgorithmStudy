find = {"0001101":0, "0011001":1, "0010011":2, "0111101":3, "0100011":4, "0110001":5, "0101111":6, "0111011":7, "0110111":8,
        "0001011":9}

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, M = map(int, input().split())

    number = ""

    for i in range(N):
        a = input().strip()
        if '1' in a:
            number = a

    if number == "":
        print(f"#{test_case} 0")

    idx = number.rfind('1')
    number = number[idx-55:idx+1]

    l = []
    for i in range(8):
        part = number[:7]
        for j, k in find.items():
            if part == j:
                l.append(k)
        number = number[7:]


    answer = 0


    if len(l) < 8:
        print(f"#{test_case} 0")
    else:
        for i in range(len(l)):
            if i % 2 == 0:
                answer += l[i] * 3
            else:
                answer += l[i]
        if answer % 10 == 0:
            print(f"#{test_case} {sum(l)}")
        else:
            print(f"#{test_case} 0")