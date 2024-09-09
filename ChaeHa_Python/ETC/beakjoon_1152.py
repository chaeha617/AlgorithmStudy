text = input().strip()
if text == "":
    print(0)
else:
    print(text.count(" ") + 1)