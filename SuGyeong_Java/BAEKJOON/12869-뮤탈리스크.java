import java.io.*;
import java.util.*;

public class Main {
    // 전역 변수 선언
    static int n; // SCV의 개수
    static int[] scv; // 각 SCV의 체력을 저장하는 배열
    static int[][][] visited; // 방문 여부와 최소 공격 횟수를 저장하는 3차원 배열
    static int[][] atacks = {{9, 3, 1}, {9, 1, 3}, {3, 1, 9}, {3, 9, 1}, {1, 9, 3}, {1, 3, 9}}; // 뮤탈리스크가 공격하는 6가지 경우의 수

    // BFS 탐색 함수 (너비 우선 탐색을 통해 최소 공격 횟수를 구함)
    static public int bfs(int x, int y, int z) {
        visited[x][y][z] = 1; // 시작점(x, y, z)을 방문 처리하고 방문 횟수를 1로 설정
        Queue<int[]> q = new LinkedList<>(); // BFS 탐색을 위한 큐 생성
        q.add(new int[] {x, y, z}); // 큐에 초기 상태(x, y, z)를 삽입
        while (!q.isEmpty()) { // 큐가 빌 때까지 반복
            int[] xyz = q.poll(); // 큐에서 하나의 상태를 꺼냄
            x = xyz[0]; // 첫 번째 SCV의 체력
            y = xyz[1]; // 두 번째 SCV의 체력
            z = xyz[2]; // 세 번째 SCV의 체력

            // 뮤탈리스크의 6가지 공격 패턴을 적용
            for (int i = 0; i < 6; i++) {
                int xx = Math.max(0, x - atacks[i][0]); // 첫 번째 SCV에 대한 공격 결과 (체력이 0 이하로 떨어지면 0으로 유지)
                int yy = Math.max(0, y - atacks[i][1]); // 두 번째 SCV에 대한 공격 결과
                int zz = Math.max(0, z - atacks[i][2]); // 세 번째 SCV에 대한 공격 결과

                if (visited[xx][yy][zz] != 0) continue; // 이미 방문한 상태라면 넘어감
                if (xx == 0 && yy == 0 && zz == 0) return visited[x][y][z]; // 모든 SCV가 파괴된 경우, 현재까지의 공격 횟수를 반환

                visited[xx][yy][zz] = visited[x][y][z] + 1; // 새로운 상태를 방문하고, 공격 횟수를 1 증가
                q.add(new int[] {xx, yy, zz}); // 새로운 상태를 큐에 삽입
            }
        }
        return 0; // 이 코드는 사실상 도달하지 않음 (모든 SCV를 파괴하지 못하는 경우는 없으므로)
    }

    // 메인 함수
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader 객체 생성
        n = Integer.parseInt(br.readLine()); // SCV의 수를 입력받음
        scv = new int[3]; // SCV의 체력을 저장할 배열을 최대 3개 크기로 선언 (최대 3개의 SCV까지 있음)
        StringTokenizer tr = new StringTokenizer(br.readLine()); // SCV들의 체력을 입력받음

        for (int i = 0; i < n; i++) {
            scv[i] = Integer.parseInt(tr.nextToken()); // 각 SCV의 체력을 배열에 저장
        }

        // SCV의 개수에 따라 방문 배열의 크기를 다르게 설정
        switch (n) {
            case 1:
                visited = new int[scv[0] + 1][1][1]; // SCV가 1개일 때 1차원 배열로 처리
                System.out.println(bfs(scv[0], 0, 0)); // BFS 탐색 시작, 두 번째와 세 번째 SCV는 존재하지 않으므로 0
                break;
            case 2:
                visited = new int[scv[0] + 1][scv[1] + 1][1]; // SCV가 2개일 때 2차원 배열로 처리
                System.out.println(bfs(scv[0], scv[1], 0)); // BFS 탐색 시작, 세 번째 SCV는 존재하지 않으므로 0
                break;
            case 3:
                visited = new int[scv[0] + 1][scv[1] + 1][scv[2] + 1]; // SCV가 3개일 때 3차원 배열로 처리
                System.out.println(bfs(scv[0], scv[1], scv[2])); // BFS 탐색 시작, 모든 SCV의 체력을 전달
                break;
        }
    }
}
