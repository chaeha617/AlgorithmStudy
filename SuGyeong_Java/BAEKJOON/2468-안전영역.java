import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y, int watermelon){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y)); // q에 현재위치 저장
        visited[x][y] = true; // 현재 위치 탐색 저장
        while (!q.isEmpty()) {
            Node node = q.poll();
            for(int i = 0; i < 4; i++) { // 인접한 4방향 탐색
                int xx = node.x + dx[i];
                int yy = node.y + dy[i];
                if (xx < 0 || xx >= n || yy < 0 || yy >= n) continue; // 범위를 벗어나면 contonue
                if (visited[xx][yy] || watermelon >= graph[xx][yy]) continue; // 다음 탐색 위치가 이미 탐색 했거나 잠길 물 높이보다 작으면 continue
                visited[xx][yy] = true; // 다음 탐색위치 탐색 저장
                q.add(new Node(xx, yy)); // 다음 탐색위치 q에 저장
            }
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n]; // n x n 크기 그래프

        for(int i = 0; i < n; i++){ // n x n 크기 그래프 입력받기
            StringTokenizer tr = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                graph[i][j] = Integer.parseInt(tr.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < 100; i++) {
            visited = new boolean[n][n];
            int temp = 0; // 물에 잠기는 높이 마다 안전영역을 카운트
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k] && graph[j][k] > i) { // 방문하지 않았으면서, 높이 i 보다 클 때
                        temp += 1;
                        bfs(j, k, i);
                    }
                }
            }
            ans = Math.max(temp, ans); // bfs 돌린 후 ans에 가장 많은 안전영역의 갯수 저장
        }
        System.out.println(ans);

    }
}