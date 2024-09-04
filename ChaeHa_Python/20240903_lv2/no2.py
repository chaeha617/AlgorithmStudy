def solution(prices):
    answer = []
    li =[]
    for idx, price in enumerate(prices):
        li.append((price, idx))
    li.sort()


    return answer

def solution(prices):
    answer = []
    for idx, price in enumerate(prices):
        priRan = prices[idx:]
        for i, pri in enumerate(priRan):
            if price > pri:
                break
        answer.append(i)

    return answer

