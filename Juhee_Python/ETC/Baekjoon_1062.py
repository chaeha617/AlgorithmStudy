N, K = map(int, input().split())
words = []

for i in range(N):
    word = set(input().rstrip())
    words.append(word)

if K < 5:
    print(0)
else:
    base_letters = {'a', 'n', 't', 'i', 'c'}
    learnable_letters = K - 5

    letter_count = dict()

    for word in words:
        for letter in word - base_letters:
            if letter in letter_count:
                letter_count[letter] += 1
            else:
                letter_count[letter] = 1

    sorted_letters = sorted(letter_count.items(), key=lambda x: x[1], reverse=True)

    learned = set(base_letters)
    max_words = 0

    for letter, _ in sorted_letters[:learnable_letters]:
        learned.add(letter)

    for word in words:
        if word.issubset(learned):
            max_words += 1

    print(max_words)
