from collections import deque

T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):

    input()
    turn = True
    numbers = deque(map(int, input().split()))
    while(turn):
        for i in range(5):

            number = max(numbers.popleft() - (i + 1),0)
            numbers.append(number)

            if number == 0:
                turn = False
                break

    print("#"+ str(test_case), " ".join(map(str, numbers)))



