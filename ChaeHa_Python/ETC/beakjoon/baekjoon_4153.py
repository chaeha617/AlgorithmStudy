
numbers = list(map(int, input().split()))
while sum(numbers) != 0:
    numbers.sort()

    if numbers[0]**2 + numbers[1]**2 == numbers[2]**2:
        print("right")
    else:
        print("wrong")

    numbers = list(map(int, input().split()))
