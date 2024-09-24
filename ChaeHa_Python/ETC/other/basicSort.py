# 선택 정렬
def selectionSort(x):
    length = len(x)
    for i in range(length-1):
        indexMin = i
        for j in range(i+1, length):
            if x[indexMin] > x[j]:
                indexMin = j
        x[i], x[indexMin] = x[indexMin], x[i]
    return x

# 삽입 정렬
def insert_sort(x):
    for i in range(1, len(x)):
        j = i - 1
        key = x[i]
        while x[j] > key and j >= 0:
            x[j+1] = x[j]
            j = j - 1
        x[j+1] = key
    return x