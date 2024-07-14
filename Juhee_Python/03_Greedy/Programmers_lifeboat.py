# 몸무게 정렬한 뒤 맨 앞의 값과 가능한 가장 큰 값 합치기

def solution(people, limit):
    people.sort() # 사람 정렬
    count = 0 # 보트 세기

    # 시작점과 끝점 (맨 앞과 뒤부터)
    start = 0
    end = len(people) - 1

    while start <= end:

        # 조건에 맞는 경우
        if people[start] + people[end] <= limit:
            start += 1 # 시작점 뒤로
            end -= 1 # 끝점 앞으로
            count += 1 # 보트 개수 추가
        else:
            end -= 1 # 끝점 앞으로
            count += 1
    return count

print(solution([70, 50, 80, 50], 100))
print(solution([70, 80, 50], 100))