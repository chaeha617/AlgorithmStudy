T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    number = int(input())
    a = list(input().rstrip())
    li = list(input().rstrip())

    answer = 0
    for i in range(len(li)):
        count = 0
        if li[i] == a[0]:
            count += 1
            if count == len(a):
                break
            for j in range(1, len(a)):
                if i+j <= len(li)-1:
                    if li[i+j] == a[j]:
                        count += 1
            if count == len(a):
                answer += 1

    print(f"#{number} {answer}")
