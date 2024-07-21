#입력 받기
N, K = map(int, input().split())
electricList = list(map(int, input().split()))

#가전제품마다 필요한 순서를 저장할 딕셔너리
electricDic = {x : [] for x in set(electricList)}

#딕셔너리에 각 가전제품이 필요한 순서를 저장
for idx, i in enumerate(electricList):
    electricDic[i].append(idx)

#multitap은 현재 멀티탭의 상태를 저장
multitap = []
count = 0

#필요한 가전제품 순서대로 반복하며 몇번 코드를 바꿔야하는지 계산
for electric in electricList:
    #필요한 가전제품이 멀티탭에 꽃혀있지 않을떄
    if not electric in multitap:
        #멀티탭에 빈 공간이 있을때
        if len(multitap) < N:
            multitap.append(electric)
        #멀티탭에 빈 공간이 없을때
        else:
            maxIdx = -1
            maxElectric = -1
            #멀티탭에 꽃혀있는 가전제품 중 가장 나중에 사용되는 가전제품 코드를 뽑음
            for idx ,i in enumerate(multitap):
                #뒤에 사용할 예정인 가전제품
                if electricDic[i] != []:
                    nextIdx = electricDic[i][0]

                    if maxIdx < nextIdx:
                        maxIdx = nextIdx
                        maxElectric = idx
                #더이상 사용하지 않을 가전제품
                else:
                    maxElectric = idx
                    break
            multitap.pop(maxElectric)
            count += 1
            multitap.append(electric)
    electricDic[electric].pop(0)

print(count)