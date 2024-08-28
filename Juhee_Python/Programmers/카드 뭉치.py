def solution(cards1, cards2, goal):
    count = 0

    for i in goal:
        if cards1 and cards1[0] == i:
            cards1.pop(0)
            count += 1
        elif cards2 and cards2[0] == i:
            cards2.pop(0)
            count += 1
        else:
            pass

    answer = ""
    if count == len(goal):
        answer += "Yes"
    else:
        answer += "No"

    return answer


print(solution(["i", "drink", "water"],["want", "to"],["i", "want", "to", "drink", "water"]	))