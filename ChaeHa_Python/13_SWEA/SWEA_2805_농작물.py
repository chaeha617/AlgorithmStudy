T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    N = int(input())
    answer = 0
    mid = N // 2
    for i in range(N):
        li = list(map(int, list(input())))
        if  i > mid:
            answer += sum(li[mid - (2 * mid - i):mid + (2 * mid - i)+1])
        else:
            answer += sum(li[mid - i : mid + i +1])
    print("#"+str(test_case),str(answer))
    # ///////////////////////////////////////////////////////////////////////////////////
