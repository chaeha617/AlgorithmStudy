import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph; // 그래프를 나타내는 2차원 배열
    static int n; // 그래프의 크기(n x n)
    static int[] dx = {1, -1, 0, 0}; // 좌우 탐색을 위한 x축 이동 변수
    static int[] dy = {0, 0, -1, 1}; // 상하 탐색을 위한 y축 이동 변수
    static int[][] visited; // 방문 상태와 현재 위치에서의 최대 경로 길이를 저장할 배열

    // 깊이 우선 탐색(DFS) 함수, 시작 좌표 (x, y)에서 탐색
    public static int dfs(int x, int y){
        visited[x][y] = 1; // 현재 좌표 방문 처리 (최소 경로 길이는 1로 설정)

        // 상하좌우 네 방향에 대해 탐색
        for (int l = 0; l < 4; l++) {
            int xx = x + dx[l]; // 새로운 x 좌표
            int yy = y + dy[l]; // 새로운 y 좌표

            // 예외처리: 그래프 범위를 벗어나는 경우나 값이 작거나 같을 경우 continue
            if (xx < 0 || xx >= n || yy < 0 || yy >= n || graph[x][y] >= graph[xx][yy])
                continue;

            // 이미 방문한 경우, 현재 경로 길이를 갱신
            if (visited[xx][yy] != 0) {
                visited[x][y] = Math.max(visited[x][y], visited[xx][yy] + 1);
                continue;
            }

            // 재귀적으로 dfs 실행 후, 현재 좌표에서의 경로 길이를 최대값으로 갱신
            visited[x][y] = Math.max(visited[x][y], dfs(xx, yy) + 1);
        }

        return visited[x][y]; // 현재 좌표에서의 최대 경로 길이 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader
        StringTokenizer tr; // 입력된 문자열을 공백 기준으로 분리하기 위한 StringTokenizer
        n = Integer.parseInt(br.readLine()); // 그래프의 크기 입력 (n x n)
        graph = new int[n][n]; // 그래프 배열 초기화
        visited = new int[n][n]; // 방문 상태 배열 초기화

        // 그래프 배열에 값 입력
        for (int i = 0 ; i < n; i++) {
            tr = new StringTokenizer(br.readLine()); // 한 줄 입력받아서 공백 기준으로 나눔
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(tr.nextToken()); // 각 칸의 값을 그래프에 저장
            }
        }

        int ansmax = 0; // 최대 경로 길이를 저장할 변수
        // 그래프 내 모든 좌표에서 DFS 실행
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ansmax = Math.max(ansmax, dfs(i, j)); // 각 좌표에서 dfs 결과 중 최대값을 ansmax에 저장
            }
        }

        // 결과 출력: 최대 경로 길이
        System.out.println(ansmax);
    }
}
