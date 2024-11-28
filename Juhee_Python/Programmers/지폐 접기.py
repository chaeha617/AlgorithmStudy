def solution(wallet, bill):
    count = 0
    while bill[0] > wallet[0] or bill[1] > wallet[1]:
        if (bill[0] <= wallet[0] and bill[1] <= wallet[1]) or (bill[1] <= wallet[0] and bill[0] <= wallet[1]):
            break
        if bill[0] > bill[1]:
            bill[0] = bill[0] // 2
            count += 1
        else:
            bill[1] = bill[1] // 2
            count += 1

    return count


solution([30, 15],[26, 17])
solution([50, 50],[100, 241])
