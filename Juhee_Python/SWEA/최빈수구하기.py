def numberGet():
    n = dict()
    mx = 0
    mx_key = None
    n2 = int(input())
    l = list(map(int, input().split()))
    for i in l:
        if i in n:
            n[i] += 1
        else:
            n[i] = 1

        if n[i] > mx:
            mx = n[i]
            mx_key = i
        elif n[i] == mx:
            if mx_key < i:
                mx_key = i
    return mx_key

T = int(input())
for test_case in range(1, T + 1):
    result = numberGet()
    print(f"#{test_case} {result}")
