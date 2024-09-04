N = int(input())

d = set()
count = 0
for i in range(N):
    a = input()
    if a != "ENTER":
        if a not in d:
            count += 1
            d.add(a)
    elif a == "ENTER":
        d.clear()
print(count)

#시간초과
# count = 0
# e = []
# for i in range(N):
#     a = input().rstrip()
#     if a == "ENTER" and a not in e:
#         e.append(a)
#     else:
#         if a not in e:
#             e.append(a)
#             count += 1
#         if a == "ENTER":
#             e = ["ENTER"]
#
# print(count)