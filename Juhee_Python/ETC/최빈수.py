T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    mx = 0
    t = int(input())
    a = list(map(int, input().split()))

    count = [[0] for _ in range(1000)]

    for i in a:
        count[i-1][0] += 1

    mx = max(count)
    answer = []
    for i in range(len(count)):
        if count[i] == mx:
            answer.append(i)


    print(f"#{test_case} {max(answer)+1}")


