score = []
h = 0

for i in range(20):
    a = list(input().split())
    if a[2] == "A+":
        score.append(4.5 * float(a[1]))
    elif a[2] == "A0":
        score.append(4.0 * float(a[1]))
    elif a[2] == "B+":
        score.append(3.5 * float(a[1]))
    elif a[2] == "B0":
        score.append(3.0 * float(a[1]))
    elif a[2] == "C+":
        score.append(2.5 * float(a[1]))
    elif a[2] == "C0":
        score.append(2.0 * float(a[1]))
    elif a[2] == "D+":
        score.append(1.5 * float(a[1]))
    elif a[2] == "D0":
        score.append(1.0 * float(a[1]))
    elif a[2] == "F":
        score.append(0 * float(a[1]))
    elif a[2] == "P":
        continue
    h += float(a[1])


a = sum(score)

print(a / h)