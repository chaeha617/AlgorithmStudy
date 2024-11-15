T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    input()
    findText = input()
    text = list(input())
    index = 0
    answer = 0
    for val in text:
        if findText[index] == val:
            index += 1
            if index >= len(findText):
                index = 0
                answer += 1
        else:
            index = 0
            if findText[index] == val:
                index += 1
                if index >= len(findText):
                    index = 0
                    answer += 1
    print("#" + str(test_case), str(answer))

# 8분