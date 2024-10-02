# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&problemLevel=4&contestProbId=AWHPkqBqAEsDFAUn&categoryId=AWHPkqBqAEsDFAUn&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=4&pageSize=10&pageIndex=1


T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    problemCnt = int(input())
    problem = list(map(int, input().split()))
    score = set()
    score.add(0)
    score.add(problem[0])
    for problemScore in problem[1:]:
        addset = set()
        for sc in score:
            addset.add(sc + problemScore)
        score = addset | score
    print("#" + str(test_case), str(len(score)))
    # ///////////////////////////////////////////////////////////////////////////////////

'''
2
3
2 3 5
10
1 1 1 1 1 1 1 1 1 1
'''