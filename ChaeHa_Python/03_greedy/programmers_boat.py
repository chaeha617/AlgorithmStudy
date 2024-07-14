def solution(people, limit):
    answer = 0
    people.sort()
    high = len(people)-1
    low = 0
    while(high >= low):
        if people[low] + people[high] <= limit:
            low += 1
        high -= 1
        answer += 1
    return answer