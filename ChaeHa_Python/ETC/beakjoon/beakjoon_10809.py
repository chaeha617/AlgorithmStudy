text = input()
alpa = [-1 for _ in range(26)]
for idx, ch in enumerate(text):
    if alpa[ord(ch) - ord("a")] == -1:
        alpa[ord(ch) - ord("a")] = idx
print(" ".join(map(str,alpa)))