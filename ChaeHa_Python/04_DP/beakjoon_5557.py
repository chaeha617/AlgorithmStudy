N = int(input())
numbers = list(map(int, input().split()))
dp = {0:[numbers[0]]}

sumNum = sum(numbers)
for i in range(1,N-1):
    numli = []
    for num in dp[i-1]:
        if num + numbers[i] <= 20 and num + numbers[i] - sumNum < numbers[-1]:
            numli.append(num + numbers[i])
        if num - numbers[i] >= 0 :
            numli.append(num - numbers[i])
    dp[i] = numli

print(dp[N-2].count(numbers[-1]))
