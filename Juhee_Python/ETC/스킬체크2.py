def solution(n):
    a = [i for i in range(1,n+1)]

    for i in range(n):
        for j in range(i+1, n+1):
            if a[i] == n:
                break
            else:
                if a[i] < n:
                    a[i] += a[j]
                else:
                    break
    return a.count(n)


print(solution(15))