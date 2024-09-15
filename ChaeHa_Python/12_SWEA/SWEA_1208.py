
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    boxlist = list(map(int, input().split()))
    for _ in range(N):
        boxlist.sort()
        if boxlist[0] == boxlist[-1]:
            break
        boxlist[0] += 1
        boxlist[-1] -= 1
    print("#"+str(test_case),max(boxlist) - min(boxlist))