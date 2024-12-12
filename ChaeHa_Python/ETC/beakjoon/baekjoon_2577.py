
result = 1
for _ in range(3):
    result *= int(input())

result = str(result)

countNumber = [0 for __ in range(10)]

for ch in result:
    countNumber[int(ch)] += 1

for val in countNumber:
    print(val)