def solution(clothes):
    answer = 1
    clothesDic = {}
    for clo, cate in clothes:
        if cate in clothesDic:
            clothesDic[cate] += 1
        else:
            clothesDic[cate] = 1

    for cate in clothesDic.keys():
        answer *= (clothesDic[cate]+ 1) #안 입음도 선택지

    return answer - 1
