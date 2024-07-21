def solution(picks, minerals):
    answer = 0

    #각각의 개수를 딕셔너리에 저장
    mineStress = {"diamond": 2, "iron": 1, "stone": 0}
    mineDic = {x: 0 for x in range(3)}
    for i in minerals:
        mineDic[mineStress[i]] += 1

    picks.reverse()
    picks = [x * 5 for x in picks]

    for i in range(3):
        mi = min(picks[i],mineDic[i])
        mineDic[i] -= mi
        picks[i] -= mi
        answer += mi


    # i는 곡괭이
    for i in range(3):
        mineCount = i
        #j는 광물
        for j in range(3):
            print(i, j ,mineCount, answer)
            if mineCount <= 0: # 곡괭이가 없음
                break
            if mineCount <= mineDic[j]: # 광물이 많거나 같음
                answer += (5 ** (max(0, j - i))) * mineCount
                mineDic[j] -= mineCount
                break
            else: # 광물이 적음
                answer += (5 ** (max(0, j - i))) * mineDic[j]
                mineCount -= mineDic[j]
                mineDic[j] = 0

    return answer

#print(solution([0, 1, 1], ["diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"]))
print(solution([1, 3, 2], ["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]))
