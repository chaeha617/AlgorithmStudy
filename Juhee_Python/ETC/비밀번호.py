def solution(li):
    a = li.copy()

    while True:
        modified = False
        i = 0
        while i < len(a) -1:
            if a[i] == a[i+1]:
                a.pop(i)
                a.pop(i)
                modified = True
                continue
            i += 1
        if not modified:
            break

    for i in range(len(a)):
        if a[0] == '0':
            a.pop(0)

    return a

T = 10

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    test = list(map(int,input().split()))
    num = test[0]
    li = list(str(test[1]))
    result = ''.join(solution(li))
    print(f"#{test_case} {result}")