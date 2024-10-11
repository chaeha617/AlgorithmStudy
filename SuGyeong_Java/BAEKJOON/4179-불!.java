import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, -1, 0, 0}; // 상하좌우 이동을 위한 x축 방향 배열
    static int[] dy = {0, 0, 1, -1}; // 상하좌우 이동을 위한 y축 방향 배열
    static int n, m; // 미로의 행(n)과 열(m)
    static String[] graph; // 미로를 나타내는 문자열 배열
    static int[][] visited; // 방문 여부와 시간 기록을 위한 배열

    // 노드를 정의하는 내부 클래스, 좌표 (x, y)를 저장
    public static class Node {
        int x;
        int y;

        public Node(int x, int y) { // 생성자: 좌표를 저장
            this.x = x;
            this.y = y;
        }
    }

    // 지훈(J)의 탈출을 위한 BFS 함수
    public static int escape (int x, int y) {
        visited[x][y] = 1; // 시작 좌표 방문 처리
        Queue<Node> q = new LinkedList<>(); // BFS 탐색을 위한 큐 선언
        q.add(new Node(x, y)); // 지훈이 있는 좌표 큐에 삽입

        while (!q.isEmpty()) { // 큐가 빌 때까지 반복
            Node node = q.poll(); // 큐에서 현재 노드 꺼냄
            for (int i = 0; i < 4; i++) { // 상하좌우 탐색
                int xx = node.x + dx[i]; // 이동 후 x좌표
                int yy = node.y + dy[i]; // 이동 후 y좌표
                // 미로를 벗어나면 탈출 성공이므로 현재 경로 반환
                if (xx < 0 || xx >= n || yy < 0 || yy >= m) {
                    return visited[node.x][node.y];
                }
                // 빈 공간('.')이 아니면 continue
                if (graph[xx].charAt(yy) != '.') continue;
                // 방문한 적 있거나 더 짧은 경로가 있으면 continue
                if (visited[xx][yy] <= visited[node.x][node.y] + 1 && visited[xx][yy] != 0) continue;
                // 새로운 좌표 방문 처리 후 큐에 추가
                visited[xx][yy] = visited[node.x][node.y] + 1;
                q.add(new Node(xx, yy));
            }
        }
        return -1; // 탈출 실패 시 -1 반환
    }

    // 불(F)이 번지는 것을 시뮬레이션하는 BFS 함수
    public static void fire(int x, int y) {
        visited[x][y] = 1; // 시작 좌표 방문 처리
        Queue<Node> q = new LinkedList<>(); // BFS 탐색을 위한 큐 선언
        q.add(new Node(x, y)); // 불이 난 좌표 큐에 삽입

        while (!q.isEmpty()) { // 큐가 빌 때까지 반복
            Node node = q.poll(); // 큐에서 현재 노드 꺼냄
            for (int i = 0; i < 4; i++) { // 상하좌우 탐색
                int xx = node.x + dx[i]; // 이동 후 x좌표
                int yy = node.y + dy[i]; // 이동 후 y좌표
                // 미로를 벗어나거나 빈 공간('.')이 아니면 continue
                if (xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
                if (graph[xx].charAt(yy) != '.') continue;
                // 더 빠르게 불이 도달한 경우 continue
                if (visited[xx][yy] <= visited[node.x][node.y] + 1 && visited[xx][yy] != 0) continue;
                // 새로운 좌표 방문 처리 후 큐에 추가
                visited[xx][yy] = visited[node.x][node.y] + 1;
                q.add(new Node(xx, yy));
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 BufferedReader
        StringTokenizer tr = new StringTokenizer(br.readLine()); // 첫 번째 줄에서 n(행), m(열) 입력받음
        n = Integer.parseInt(tr.nextToken()); // 행
        m = Integer.parseInt(tr.nextToken()); // 열
        graph = new String[n]; // 미로 정보를 저장할 문자열 배열 초기화
        visited = new int[n][m]; // 방문 여부와 시간 기록 배열 초기화
        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine(); // 각 행에 대한 미로 정보 입력
        }

        // 불이 난 위치들에서 불이 퍼지는 시뮬레이션 실행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i].charAt(j) == 'F') { // 불이 시작된 좌표
                    fire(i, j); // 해당 좌표에서 불이 퍼지도록 BFS 실행
                }
            }
        }

        int ans = 0; // 탈출에 성공했을 때의 결과값
        // 지훈이의 위치에서 탈출 경로 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i].charAt(j) == 'J') { // 지훈이 위치
                    ans = escape(i, j); // 탈출 시도
                }
            }
        }
        // 탈출이 불가능할 경우 "IMPOSSIBLE" 출력, 가능하면 시간 출력
        if (ans == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(ans);
        }

    }
}
