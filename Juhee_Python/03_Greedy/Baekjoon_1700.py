N, K = map(int,input().split())
W = list(map(int, input().split()))

stack = []
count = 0

for i in range(K):
    if W[i] in stack: # 콘센트에 꽂혀있는 친구라면 넘기기
        continue
    if len(stack) < N: # 콘센트가 비었다면 넣어주기
        stack.append(W[i])
    else:
        index1 = -1 # 교체할 인덱스
        index2 = -1 # 뒤에서 나오는 인덱스
        found = False # 뒤에서 나오는 인덱스를 찾았는지 여부

        for j in range(N): # 교체할 위치 중 인덱스가 가장 큰 값 (가장 뒤에 나오는 값 찾기)
            if stack[j] in W[i+1:]: # 뒤에 나온다면
                index = W[i+1:].index(stack[j]) # 뒤에서 나오는 인덱스 저장
                if index > index2: # 뒤에서 나오는 인덱스가 더 크다면
                    index2 = index # 최대 인덱스 업데이트
                    index1 = j # 교체할 위치
                    found = True # 찾았음
            else: # 뒤에 안 나온다면
                index1 = j # 현재 위치가 교체할 위치
                found = True # 찾았음
                break

        if found:
            stack.pop(index1) # 교체
            stack.append(W[i]) # 교체
            count += 1 # 뽑기



print(count)
