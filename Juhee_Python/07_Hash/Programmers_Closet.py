def solution(clothes):
    closet = {}

    # 옷 종류별로 옷 이름을 딕셔너리에 저장
    for name, kind in clothes:
        if kind in closet:
            closet[kind].append(name)
        else:
            closet[kind] = [name]


    # 모든 조합의 수를 계산
    counts = [len(items) + 1 for items in closet.values()]

    total_combinations = 1
    for count in counts:
        total_combinations *= count

    # 아무것도 선택하지 않는 경우 (1가지 경우)를 뺌
    return total_combinations - 1



#print(solution([["a", "A"], ["b", "B"], ["c", "C"]]))
print(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))
#print(solution([["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]))