
T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    N = int(input())
    buildingList = list(map(int, input().split()))
    answer = 0
    for idx in range(2,N-2):
        aroundBuilding = max(buildingList[idx-2],buildingList[idx-1],buildingList[idx+1],buildingList[idx+2])
        if buildingList[idx] > aroundBuilding:
            answer += buildingList[idx] - aroundBuilding

    print("#"+str(test_case),str(answer))
    # ///////////////////////////////////////////////////////////////////////////////////

'''
10
0 0 254 185 76 227 84 175 0 0
10
0 0 251 199 176 27 184 75 0 0
11
0 0 118 90 243 178 99 100 200 0 0
'''