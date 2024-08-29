# 상위 k번째 이내이면 명예의전당에 올림
# 기존 목록의 k번ㅉ ㅐ순위 가수 점수보다 높으면 명예의 전당 바뀜
# 매일 명예의전당 최하위 점수 발표

def solution(k, score):
    answer = []
    sc = []
    for i in score:
        if len(answer) < k:
            sc.append(i)
            answer.append(min(sc))
        else:
            sc.append(i)
            sc.remove(min(sc))

            answer.append(min(sc))

    return answer

print(solution(3, [10, 100, 20, 150, 1, 100, 200]))
print(solution(4, [0, 300, 40, 300, 20, 70, 150, 50, 500, 1000]))