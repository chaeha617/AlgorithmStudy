// 백트래킹 알고리즘을 사용한 조합 찾기
public void backtracking(int[] sequence, boolean[] visited, int N, int M, int depth) {
    // 종료 조건: 수열의 길이가 M에 도달하면 출력
    if (depth == M) {
        for (int num : sequence) {
            System.out.print(num + " ");
        }
        System.out.println();
        return;
    }

    for (int i = 1; i <= N; i++) {
        // 선택한 숫자보다 큰 숫자 중에서 방문하지 않은 숫자 선택
        if (!visited[i] && (depth == 0 || sequence[depth - 1] < i)) {
            sequence[depth] = i; // 수열에 추가
            visited[i] = true; // 방문 표시
            backtracking(sequence, visited, N, M, depth + 1); // 다음 숫자 선택
            visited[i] = false; // 방문 상태 초기화
        }
    }
}