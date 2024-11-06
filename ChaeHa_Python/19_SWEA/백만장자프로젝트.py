
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    prices = list(map(int, input().split()))
    prices.reverse()
    benefit = 0
    maxPrice = prices[0]
    for price in prices[1:]:
        if price < maxPrice:
            benefit += maxPrice - price
        maxPrice = max(price, maxPrice)

    print("#"+str(test_case),str(benefit))