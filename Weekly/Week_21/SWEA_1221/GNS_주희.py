T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    a = list(input().split())[0] # 테스트케이스 번호

    planet = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]

    li = list(input().split())
    li.sort(key = lambda x:planet.index(x))
    print(a)
    print(' '.join(li))