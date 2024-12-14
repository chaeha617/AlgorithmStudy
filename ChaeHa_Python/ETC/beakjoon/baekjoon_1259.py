number = input()
while number !=  '0':
    if number[::-1] == number:
        print("yes")
    else:
        print("no")
    number = input()