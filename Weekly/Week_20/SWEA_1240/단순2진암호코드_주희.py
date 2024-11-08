d = {
    "0001101": 0, "0011001": 1, "0010011": 2, "0111101": 3,
    "0100011": 4, "0110001": 5, "0101111": 6, "0111011": 7,
    "0110111": 8, "0001011": 9
}

T = int(input())

for test_case in range(1, T + 1):
    N, M = map(int, input().split())  # 세로 가로
    graph = []

    for _ in range(N):
        row = input().strip()
        if '1' in row:
            graph.append(row)

    binary_string = graph[-1]
    end_index = binary_string.rfind('1') + 1
    start_index = end_index - 56

    code_string = binary_string[start_index:end_index]
    answer = []

    for i in range(0, len(code_string), 7):
        segment = code_string[i:i+7]
        if segment in d:
            answer.append(d[segment])
        else:
            answer = []
            break

    s1 = 0
    s2 =0

    for i in range(1, 9):
        if i % 2 == 1:
            s1 += answer[i-1]
        else:
            s2 += answer[i-1]

    if (s1*3 + s2) % 10 == 0:
        result = sum(answer)
    else:
        result = 0

    print(f"#{test_case} {result}")
