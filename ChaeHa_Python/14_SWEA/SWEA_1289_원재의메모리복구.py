# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&problemLevel=4&contestProbId=AV19AcoKI9sCFAZN&categoryId=AV19AcoKI9sCFAZN&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=4&pageSize=10&pageIndex=1


'''
2
0011
100
'''


T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    memory = input()
    cnt = 0
    nowCh = '0'
    for ch in memory:
        if nowCh != ch:
            cnt += 1
            nowCh = ch
    print("#"+str(test_case),str(cnt))

    # ///////////////////////////////////////////////////////////////////////////////////
